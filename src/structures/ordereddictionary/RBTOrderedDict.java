package structures.ordereddictionary;


import structures.tree.binarysearchtree.BinarySearchTree;
import structures.tree.binarysearchtree.RBTree;

import java.util.Comparator;


public class RBTOrderedDict<K, V> extends AbstractTreeOrderedDict<K, V> {

	public RBTOrderedDict() {
		super();
	}

	public RBTOrderedDict(Comparator<K> keyComparator) {
		super(keyComparator);
	}
	
	@Override
	protected BinarySearchTree<Entry<K,V>> createTree() {
		return new RBTree<>();
	}
	
}


