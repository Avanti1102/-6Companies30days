class Day10 {
    public int amountOfTime(TreeNode root, int start) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        convertTreetoGraph(root, 0, map);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(start);
        int minutes = 0;
        while(!queue.isEmpty()){
            int qsize = queue.size();
            while(qsize >0){
                int current = queue.poll();
                for(int num : map.get(current)){
                    if(!visited.contains(num)){
                        queue.add(num);
                        visited.add(num);
                    }
                }
                qsize--;
            }
            minutes++;
        }
        return minutes-1;
    }   
    private void convertTreetoGraph(TreeNode current, int parent, Map<Integer, Set<Integer>> map){
        if(current!=null){
            if(!map.containsKey(current.val)){
                map.put(current.val, new HashSet<>());
            }
            Set<Integer> adjecentList = map.get(current.val);
            if(parent!=0){
                adjecentList.add(parent);
            }
            if(current.left!=null){
                adjecentList.add(current.left.val);
            }
            if(current.right!=null){
                adjecentList.add(current.right.val);
            }
            convertTreetoGraph(current.left, current.val, map);
            convertTreetoGraph(current.right, current.val, map);
        }
    }
}