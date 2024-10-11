import java.util.*;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        PathBetweenBranches branchGraph = new PathBetweenBranches();

        // Adding some branches
        branchGraph.addBranch("Main Branch");
        branchGraph.addBranch("East Branch");
        branchGraph.addBranch("West Branch");

        // Adding distances between branches
        branchGraph.addEdge("Main Branch", "East Branch", 10);
        branchGraph.addEdge("Main Branch", "West Branch", 15);
        branchGraph.addEdge("East Branch", "West Branch", 5);

        // Adding books
        library.addBook(new Book("The Alchemist", "Paulo Coelho", "123", "Main Branch"));
        library.addBook(new Book("1984", "George Orwell", "124", "East Branch"));

        // Adding members
        library.addMember(new Member(1, "Alice"));
        library.addMember(new Member(2, "Bob"));

        // Issue and return books
        library.issueBook(1, "123");
        library.returnBook(1, "123");

        // Find the shortest path between branches using Dijkstra
        Map<String, Integer> shortestPaths = branchGraph.dijkstra("Main Branch");
        for (String branch : shortestPaths.keySet()) {
            System.out.println("Shortest distance to " + branch + ": " + shortestPaths.get(branch));
        }
    }
}
