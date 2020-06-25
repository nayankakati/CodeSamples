/*
package code.gladiators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import javafx.util.Pair;

*/
/**
 * Created by nayan.kakati on 5/1/18.
 *//*

public class Gladit {
	// 1. store the vertices in an array
	// 2. calculate if there is a path between the paths
	// 3. based on the visited array, add the gifts total in vertices

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int noOfHouses = scanner.nextInt();
		int noOfSantaVisit = scanner.nextInt();

		List<Pair<Integer, Integer>> santasPath = new ArrayList<>();

		Graph graph = new Graph(noOfHouses);

		for(int i=0; i< noOfHouses-1; ++i){
			int edge1 = scanner.nextInt();
			int edge2 = scanner.nextInt();
			graph.addEdge(edge1, edge2);
		}
		for(int j=0 ; j< noOfSantaVisit ; j++) {
			int from = scanner.nextInt();
			int to = scanner.nextInt();
			Pair pair =  new Pair(from, to);
			santasPath.add(pair);
		}

		int[] gifts =  new int[noOfHouses];
		for(int k=0 ; k< noOfSantaVisit ; k++) {
			Set<Integer> currentPathVisited;
			int startNode = santasPath.get(k).getKey()-1;
			int endNode = santasPath.get(k).getValue()-1;
			currentPathVisited = getCurrentPathFromSourceToDestination(startNode, endNode, noOfHouses, graph);
			calculateTheGifts(currentPathVisited, gifts);
		}
		AtomicInteger maxGifts = new AtomicInteger(-1);
		Arrays.stream(gifts).forEach(gift -> {
			if(gift > maxGifts.get())
				maxGifts.set(gift);
		});

		System.out.println(maxGifts.get());
	}

	private static void calculateTheGifts(Set<Integer> currentPathVisited, int[] gifts) {
		Iterator<Integer> curr = currentPathVisited.iterator();
		while (curr.hasNext()) {
			int n = curr.next();
			gifts[n] = gifts[n] + 1;
		}
	}

	private static Set<Integer> getCurrentPathFromSourceToDestination(int startNode, int endNode, int noOfHouses, Graph graph) {
		boolean visited[] = new boolean[noOfHouses];
		LinkedList<Integer> adj[] =  graph.adj;
		LinkedList<Integer> queue = new LinkedList<>();
		Set<Integer> parent =  new HashSet<>();

		visited[startNode]=true;
		queue.add(startNode);
		parent.add(startNode);
		Iterator<Integer> i;
		while (queue.size()!=0)
		{
				startNode = queue.poll();
				int n;
				i = adj[startNode].listIterator();
				while (i.hasNext())
				{
					n = i.next();
					if (n == endNode) { visited[endNode] = true;
					  parent.add(startNode);
						parent.add(endNode);
						return parent;
					}
					if (!visited[n])
					{
						visited[n] = true;
						queue.add(n);
						parent.add(startNode);
					}
				}
		}
		return parent;
	}

	private static class Graph {
		private LinkedList<Integer> adj[];
		Graph(int v) {
			adj = new LinkedList[v];
			for (int i=0 ;i<v; i++) {
				adj[i] = new LinkedList<>();
			}
		}
		public void addEdge(int v, int w) {
			adj[v-1].add(w-1);
			adj[w-1].add(v-1);
		}
	}
}
*/
