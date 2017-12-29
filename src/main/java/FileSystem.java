/*
588. Design In-Memory File System
DescriptionHintsSubmissionsDiscussSolution

Design an in-memory file system to simulate the following functions:

ls: Given a path in string format. If it is a file path, return a list that only contains this file's name. If it is a directory path, return the list of file and directory names in this directory. Your output (file and directory names together) should in lexicographic order.

mkdir: Given a directory path that does not exist, you should make a new directory according to the path. If the middle directories in the path don't exist either, you should create them as well. This function has void return type.

addContentToFile: Given a file path and file content in string format. If the file doesn't exist, you need to create that file containing given content. If the file already exists, you need to append given content to original content. This function has void return type.

readContentFromFile: Given a file path, return its content in string format.

Example:

Input: 
["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
[[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]
Output:
[null,[],null,null,["a"],"hello"]
Explanation:
filesystem

Note:

    You can assume all file or directory paths are absolute paths which begin with / and do not end with / except that the path is just "/".
    You can assume that all operations will be passed valid parameters and users will not attempt to retrieve file content or list a directory or file that does not exist.
    You can assume that all directory names and file names only contain lower-case letters, and same names won't exist in the same directory.


*/class FileSystem {
    private static class TreeNode{
        Map<String, TreeNode> map = new HashMap<>();
        boolean isFile = false;
        String name = "";
        String Name;
    }
    
    TreeNode root;
    
    public FileSystem() {
        root = new TreeNode();
    }
    
    public List<String> ls(String path) {
        String[] s = path.split("/");
        TreeNode tmp = root;
        for (int i = 1; i < s.length; i++) {
            tmp = tmp.map.get(s[i]);
        }
        List<String> list = new ArrayList<>(tmp.map.keySet());
        if (tmp.Name != null) {
            list.add(tmp.Name);
        }
        Collections.sort(list);
        return list;
    }
    
    public void mkdir(String path) {
        String[] s = path.split("/");
        TreeNode tmp = root;
        for (int i = 1; i < s.length; i++) {
            tmp.map.putIfAbsent(s[i], new TreeNode());
            tmp = tmp.map.get(s[i]);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        String[] s = filePath.split("/");
        TreeNode tmp = root;
        for (int i = 1; i < s.length; i++) {
            tmp.map.putIfAbsent(s[i], new TreeNode());
            tmp = tmp.map.get(s[i]);
        }
        tmp.name = tmp.name + content;
        tmp.Name = s[s.length - 1];
        tmp.isFile = true;
    }
    
    public String readContentFromFile(String filePath) {
        String[] s = filePath.split("/");
        TreeNode tmp = root;
        for (int i = 1; i < s.length; i++) {
            tmp = tmp.map.get(s[i]);
        }
        return tmp.name;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
