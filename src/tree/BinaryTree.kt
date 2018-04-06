package tree

import java.util.*
import javax.swing.Spring.height
import javax.swing.Spring.height


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

    fun newNode(data: Int): Node {
        val n = Node(data)
        n.left = null
        n.right = null
        return n
    }

    fun addNode(data: Int, head: Node?): Node? {
        var head = head
        val tempHead = head
        val n = newNode(data)
        if (head == null) {
            head = n
            return head
        }
        var prev: Node? = null
        while (head != null) {
            prev = head
            if (head.data < data) {
                head = head.right
            } else {
                head = head.left
            }
        }
        if (prev!!.data < data) {
            prev.right = n
        } else {
            prev.left = n
        }
        return tempHead
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

    fun printNodesInSpiralOrder(root: Node?) {
        if (root == null) {
            return;
        }

        var stackLeft = Stack<Node>()
        var stackRight = Stack<Node>()
        stackLeft.push(root)

        while (!stackLeft.isEmpty() || !stackRight.isEmpty()) {

            while (!stackLeft.isEmpty()) {
                val temp: Node = stackLeft.pop()
                println(temp.data)
                temp.right?.let { stackRight.push(temp.right) }
                temp.left?.let { stackRight.push(temp.left) }

            }
            while (!stackRight.isEmpty()) {
                val temp: Node = stackRight.pop()
                println(temp.data)
                temp.right?.let { stackLeft.push(temp.left) }
                temp.left?.let { stackLeft.push(temp.right) }
            }
        }
    }

    fun isTreeBSTOrNot(root: Node?, minVal: Int, maxVal: Int): Boolean {

        root?.left?:run{ root?.right ?:run { return false } }

        if (root == null) {
            return false
        }
        if (root.data > maxVal || root.data <= minVal) {
            return false
        }
        return isTreeBSTOrNot(root.left, minVal, root.data) && isTreeBSTOrNot(root.right, maxVal, root.data)
    }

    fun isBstOrNot(root: TreeNode?, minVal: Int, maxVal: Int): Boolean {
        if (root == null) {
            return true
        }
        if (root.`val` > maxVal || root.`val` <= minVal) {
            return false
        }
        return isBstOrNot(root.left, minVal, root.`val` ) && isBstOrNot (root.right, root.
                `val` , maxVal)
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

    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}

fun main(args: Array<String>) {

    /*val tree = BinaryTree()
    tree.root = BinaryTree.Node(1)
    tree.root!!.left = BinaryTree.Node(2)
    tree.root!!.right = BinaryTree.Node(3)
    tree.root!!.left!!.left = BinaryTree.Node(7)
    tree.root!!.left!!.right = BinaryTree.Node(6)
    tree.root!!.right!!.left = BinaryTree.Node(5)
    tree.root!!.right!!.right = BinaryTree.Node(4)*/

    val bt = BinaryTree()
    var head: BinaryTree.Node? = null
    head = bt.addNode(10, head)
    head = bt.addNode(15, head)
    head = bt.addNode(5, head)
    head = bt.addNode(7, head)
    head = bt.addNode(19, head)
    head = bt.addNode(20, head)
    head = bt.addNode(-1, head)
    head = bt.addNode(21, head)
    println("Spiral Order traversal of Binary Tree is ")
    bt.printNodesInSpiralOrder(head)
    println("Height of binary tree is " + bt.heightOfTree(head))

    //println("Level order traversal of binary tree is ")
    bt.printLevelOrder(head!!)
    bt.isTreeBSTOrNot(head, Int.MIN_VALUE, Int.MAX_VALUE)
}


