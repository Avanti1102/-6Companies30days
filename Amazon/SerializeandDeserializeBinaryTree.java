public class Day12{
    public String serialization(TreeNode root){
        StringBuilder sb = new StringBuilder();
        serialHelper(sb, root);
        return sb.toString();
    }
    private void serialHelper(StringBuilder sb, TreeNode root){
        if(root==null){
            sd.append("*,");
            return;
        }
        sb.append(root.val).append(",");
        serialHelper(sb, root.left);
        serialHelper(sb, root.right);
    }

    public TreeNode deserialize(String data){
        Queue<String> nodes = new LinkedList<String>(Arrays.asList(data.split(",")));
        return deserialHelper(nodes);
    }
    private TreeNode deserialHelper(Queue<String> nodes){
        String val = nodes.poll();
        if(val.equals("*")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserialHelper(nodes);
        root.right = deserialHelper(nodes);

        return root;
    }

}