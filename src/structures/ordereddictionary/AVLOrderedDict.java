package structures.ordereddictionary;

import structures.tree.binarysearchtree.AVLTree;
import structures.tree.binarysearchtree.BinarySearchTree;

import java.util.Comparator;


public class AVLOrderedDict<K, V> extends AbstractTreeOrderedDict<K, V> {

	public AVLOrderedDict() {
		super();
	}

	public AVLOrderedDict(Comparator<K> keyComparator) {
		super(keyComparator);
	}
	
	
	@Override
	protected BinarySearchTree<Entry<K,V>> createTree() {
		return new AVLTree<>();
	}
	
}
