import java.util.ArrayList;

class Node {
	Node[] ref = new Node[26];
}

class Trie {
	Node root = new Node();

	private void add(Node currentRoot, String s) {
		if (!s.isEmpty()) {
			if (currentRoot.ref[s.charAt(0) - 'a'] == null) {
				currentRoot.ref[s.charAt(0) - 'a'] = new Node();
			}
			add(currentRoot.ref[s.charAt(0) - 'a'], s.substring(1));
		}
	}

	public void insert(String s) {
		add(root, s);
	}

	public ArrayList<String> getAllPrefixMatched(String prefix) {
		ArrayList<String> result = new ArrayList<>();
		dfs(result, prefix, root, "");
		return result;
	}

	private void dfs(ArrayList<String> result, String prefix, Node currentRoot, String currentStr) {
		if (prefix.isEmpty()) {
			boolean hasChild = false;
			for (int i = 0; i < currentRoot.ref.length; i++) {
				if (currentRoot.ref[i] != null) {
					dfs(result, prefix, currentRoot.ref[i], currentStr + (char) ('a' + i));
					hasChild = true;
				}
			}
			if (!hasChild)
				result.add(currentStr);

		} else {
			dfs(result, prefix.substring(1), currentRoot.ref[prefix.charAt(0) - 'a'], currentStr + prefix.charAt(0));
		}
	}

}

public class TrieApp {
	public static void main(String[] args) {
		Trie t = new Trie();
		t.insert("abc");
		t.insert("adb");
		t.insert("aslkdja");
		t.insert("abbb");
		t.insert("aklis");
		t.insert("avgin");
		ArrayList<String> res = t.getAllPrefixMatched("av");
		for (String s : res) {
			System.out.println(s);
		}
	}
}
