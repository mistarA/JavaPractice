package tree

import java.util.*


class BinaryTree() {

    var root: Node? = null

    init {
        root = null
    }

    class Node(private var key: Int) : Comparable<Node> {
        override fun compareTo(other: Node): Int {
            return this.data - other.data
        }

        var left: Node? = null
        var right: Node? = null
        val data = key;
    }

    fun printLevelOrder(tree: Node) {
        var nodesQueue = LinkedList<Node>()
        nodesQueue.add(tree)
        while (!nodesQueue.isEmpty()) {
            val tempNode = nodesQueue.poll()
            println(tempNode.data)
            if (tempNode.left != null) {
                nodesQueue.add(tempNode.left!!)
            }
            if (tempNode.right != null) {
                nodesQueue.add(tempNode.right!!)
            }
        }
    }

    fun heightOfTree(root: Node?): Int {
        if (root == null) {
            return 0
        } else {
            val lheight = heightOfTree(root.left)
            val rheight = heightOfTree(root.right)
            return if (lheight > rheight) {
                lheight + 1
            } else {
                rheight + 1
            }

        }
    }
}

fun main(args: Array<String>) {
    var tree = BinaryTree()
    tree.root = BinaryTree.Node(1)
    tree.root!!.left = BinaryTree.Node(2)
    tree.root!!.right = BinaryTree.Node(3)
    tree.root!!.left?.left = BinaryTree.Node(4)
    tree.root!!.left?.right = BinaryTree.Node(5)
    println("Height of binary tree is " + tree.heightOfTree(tree.root))

    //println("Level order traversal of binary tree is ")
    tree.printLevelOrder(tree.root!!)
}
