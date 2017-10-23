    // 210. Course Schedule II

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] requireCount = new int[numCourses];
        int[] res = new int[numCourses];
        int resIndex = 0;
        ArrayList<Integer>[] provide = new ArrayList[numCourses];
        for (int[] i : prerequisites) {
            requireCount[i[0]] ++;
            if (provide[i[1]] == null) provide[i[1]] = new ArrayList();
            provide[i[1]].add(i[0]);
        }
        LinkedList<Integer> queue = new LinkedList();
        for (int i = 0; i < numCourses; i++) 
            if (requireCount[i] == 0) queue.add(i);
        while (!queue.isEmpty()) {
            int cur = queue.removeFirst();
            res[resIndex++] = cur;
            if (provide[cur] == null) continue;
            for (int i : provide[cur])
                if (--requireCount[i] == 0)
                    queue.addLast(i);
        }
        return resIndex == numCourses ? res : new int[]{};
    }