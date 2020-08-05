//你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。 
//
// 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1] 
//
// 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？ 
//
// 
//
// 示例 1: 
//
// 输入: 2, [[1,0]] 
//输出: true
//解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。 
//
// 示例 2: 
//
// 输入: 2, [[1,0],[0,1]]
//输出: false
//解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。 
// 你可以假定输入的先决条件中没有重复的边。 
// 1 <= numCourses <= 10^5 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 
// 👍 446 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //https://leetcode-cn.com/problems/course-schedule/solution/tuo-bu-pai-xu-de-ban-fa-pan-duan-you-xiang-tu-shi-/
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;//n条边
        ArrayList<Integer>[] adjacencyList = new ArrayList[numCourses];//邻接表
        int[] inDegree = new int[numCourses];//入度数组 inDegree[i] 节点i的入度
        //边的集合构建邻接表
        for (int i = 0; i < numCourses; i++) {
            adjacencyList[i] = new ArrayList<>();//节点i的下标为i
        }
        for (int[] pre : prerequisites) {
            // pre=[0，1] 1是边起点 0是终点， 1节点指向0节点
            adjacencyList[pre[1]].add(pre[0]);// 后面的(1)指向 前面的(0)
            inDegree[pre[0]]++;//入度增加
        }

        //拓扑排序判断是不是DAG
        return topologicalSort(adjacencyList, inDegree, numCourses);
    }

    private boolean topologicalSort(ArrayList<Integer>[] adjacencyList, int[] inDegree, int n) {
        int res = 0;//拓扑排序能去除来的节点数目
        Queue<Integer> queue = new LinkedList<>();//存储入读的0节点
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {//入度0了
                queue.offer(i);//节点i的入度为0，加入队列
            }
        }
        while (!queue.isEmpty()) {
            int i = queue.poll();//取出节点i;
            res++;
            for (int child_of_i : adjacencyList[i]) {//对节点i指向的每一个节点
                inDegree[child_of_i]--;//删除 当前节点的指向
                if (inDegree[child_of_i] == 0) queue.offer(child_of_i);
            }
        }
        return res == n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
