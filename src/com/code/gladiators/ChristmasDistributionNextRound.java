/*
package com.code.gladiators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javafx.util.Pair;

*/
/**
 * Created by nayan.kakati on 5/1/18.
 *//*

public class ChristmasDistributionNextRound {

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
		// here visit the node according to
		for(int k=0 ; k< noOfSantaVisit ; k++) {
			final int j = k;
			int startNode = santasPath.get(k).getKey() - 1;
			int endNode = santasPath.get(k).getValue()-1;

			while(true) {
				List<Gifts> tempStartNodes = graph.adj[startNode];
				// check if last node is in this path ignore the other
				if(tempStartNodes.stream().count() > 2)
				  checkIfLastNodeFellInThisPath(tempStartNodes, graph, endNode, noOfHouses);
				else {
					for (Gifts tempo : tempStartNodes) {
							Gifts temp = graph.adj[tempo.getV()].get(0);
							temp.setGifts(temp.getGifts() + 1);
						}
				}
			}
		}

		System.out.println(graph.adj);
		*/
/*AtomicInteger maxGifts = new AtomicInteger(-1);

		Arrays.stream(graph.adj).flatMap(giftss -> Stream.of(giftss)).forEach(
			giftss -> {
				if(maxGifts.get() < giftss.get(0).getGifts())
				maxGifts.set(giftss.get(0).getGifts());
			}
		);
		System.out.println(maxGifts.get());*//*

 	}

 	private static long checkIfLastNodeFellInThisPath(List<Gifts> tempStartNodes, Graph graph, int endNode, int noOfHouses) {
		long l = tempStartNodes.stream().filter(gifts -> gifts.getV() == endNode).count();
		int vertex = -1;
		for(int i=0 ;i<noOfHouses-1;i++) {

		}

		return l;
	}
 	private static class Graph {
		Gifts gift;
		private LinkedList<Gifts> adj[];
		Graph(int v) {
			adj = new LinkedList[v];
			for (int i=0 ;i<v; i++) {
				adj[i] = new LinkedList<>();
				adj[i].add(new Gifts(i, 0));
			}
		}
		public void addEdge(int v, int w) {
			adj[v-1].add(new Gifts(w-1,0));
			//adj[w-1].add(new Gifts(v-1,0));
		}
	}

	private static class Gifts {
		private int V;
		private int gifts;
		Gifts(int v, int gifts) {
			this.V = v;
			this.gifts = gifts;
		}
		public int getV() {
			return V;
		}
		public void setV(int v) {
			V = v;
		}
		public int getGifts() {
			return gifts;
		}
		public void setGifts(int gifts) {
			this.gifts = gifts;
		}
	}
}
*/
