package com.javamasterclass;

public class SearchTree implements NodeList {
    private ListItem root = null;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            // The tree was empty, so our item becomes the head of the tree
            this.root = newItem;
            return true;
        }
        // Otherwise, start comparing from the head of the tree
        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = (currentItem.compareTo(newItem));
            if (comparison < 0) {
                // newItem is greater, move right if possible
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    // There's no node to the right, so add at this point
                    currentItem.setNext(newItem);
                    return true;
                }
            } else if (comparison > 0) {
                // newItem is less, move left if possible
                if (currentItem.previous() != null) {
                    currentItem = currentItem.previous();
                } else {
                    // There's no node to the left, so add at this point
                    currentItem.setPrevious(newItem);
                    return true;
                }
            } else {
                // Equal, so don't add
                System.out.println(newItem.getValue() + " is already present");
                return false;
            }
        }
        // We can't actually get here, but Java complains if there's no return
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        /*
        if (item != null) {
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison == 0) {
                // Found the item to delete
                if (currentItem == this.root) {
                    this.root = currentItem.next();
                } else {
                    currentItem.previous().setNext(currentItem.next());
                    if (currentItem.next() != null) {
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            } else if (comparison < 0) {
                currentItem = currentItem.next();
            } else {
                // comparison > 0
                // We are at an item greater than the one to be deleted so the item is not in the list
                return false;
            }
        }
        // We have reached the end of the list without finding the item to delete
        return false;
         */
        if (item != null) {
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;
        while (currentItem != null) {
            int comparison = (currentItem.compareTo(item));
            if (comparison < 0) {
                parentItem = currentItem;
                currentItem = currentItem.next();
            } else if (comparison > 0) {
                parentItem = currentItem;
                currentItem = currentItem.previous();
            } else {
                // Equal: we've found the item so remove it
                performRemoval(currentItem, parentItem);
                return true;
            }
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        // Recursive method

        if (root != null) {
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }
        /*
        if (root != null) {
            System.out.println(root.getValue());
            traverse(root.next());
            // 9,000,000,000,000,000,000 nodes!!!
        }
         */
    }

    private void performRemoval(ListItem item, ListItem parent) {
        // Remove item from the tree
        if (item.next() == null) {
            // No right tree, so make parent point to left tree (which may be null)
            if (parent.next() == item) {
                // Item is right child of its parent
                parent.setNext(item.previous());
            } else if (parent.previous() == item) {
                // Item is left child of its parent
                parent.setPrevious(item.previous());
            } else {
                // Parent must be item, which means we were looking at the root of the tree
                this.root = item.previous();
            }
        } else if (item.previous() == null) {
            // No left tree, so make parent point to right tree (which may be null)
            if (parent.next() == item) {
                // Item is right child of its parent
                parent.setNext(item.next());
            } else if (parent.previous() == item) {
                // Item is left child of its parent
                parent.setPrevious(item.next());
            } else {
                // Again, we are deleting the root
                this.root = item.next();
            }
        } else {
            // Neither left nor right are null, deletion is now a lot trickier!
            // From the right sub-tree, find the smallest value (i.e., the leftmost)
            ListItem current = item.next();
            ListItem leftmostParent = item;
            while (current.previous() != null) {
                leftmostParent = current;
                current = current.previous();
            }
            // Now put the smallest value into our node to be deleted
            item.setValue(current.getValue());
            // And delete the smallest
            if (leftmostParent == item) {
                // There was no leftmost node, so 'current' points to the smallest
                // Node (the one that must now be deleted).
                item.setNext(current.next());
            } else {
                // Set the smallest node's parent to point to
                // The smallest node's right child (which may be null).
                leftmostParent.setPrevious(current.next());
            }
        }
    }
}
