# **Graphs DSA Sheet**

## GRAPH IMPLEMENTATION CORE (12 Must-Do Problems)

| #   | Topic                                                                                                                       | Key Concepts                            |
| --- | --------------------------------------------------------------------------------------------------------------------------- | --------------------------------------- |
| 1   | [Graph Representation (Adjacency List/Matrix)](https://www.geeksforgeeks.org/graph-and-its-representations/)                | Directed vs Undirected, Sparse vs Dense |
| 2   | [DFS Traversal](https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/)                                       | Recursive + Visited\[]                  |
| 3   | [BFS Traversal](https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/)                                     | Queue-Based Level Order                 |
| 4   | [Detect Cycle in Undirected Graph](https://www.geeksforgeeks.org/detect-cycle-undirected-graph/)                            | DFS, DSU                                |
| 5   | [Detect Cycle in Directed Graph](https://www.geeksforgeeks.org/detect-cycle-in-a-graph/)                                    | DFS + RecStack                          |
| 6   | [Disjoint Set (DSU)](https://www.geeksforgeeks.org/union-find/)                                                             | Path Compression, Union by Rank         |
| 7   | [Topological Sort using DFS](https://www.geeksforgeeks.org/topological-sorting/)                                            | DAG + Post-order stack                  |
| 8   | [Topological Sort using Kahn's Algorithm (BFS)](https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/) | Indegree + Queue                        |
| 9   | [Dijkstra’s Algorithm](https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/)                      | Min Heap (PriorityQueue)                |
| 10  | [Bellman-Ford Algorithm](https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/)                                       | Relax all edges (V-1 times)             |
| 11  | [Floyd-Warshall Algorithm](https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/)                                   | All Pairs Shortest Path (DP)            |
| 12  | [Prim’s MST Algorithm](https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/)                        | MST using Min Heap                      |
| 13  | [Kruskal’s MST Algorithm](https://www.geeksforgeeks.org/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/)            | MST using DSU                           |

##

## GRAPH DSA — EASY LEVEL PROBLEMS (42 Total)

| #   | Problem                                                                                                                | Concept                      |
| --- | ---------------------------------------------------------------------------------------------------------------------- | ---------------------------- |
| 1   | [Number of Provinces](https://leetcode.com/problems/number-of-provinces/)                                              | Connected components (DFS)   |
| 2   | [Find the Town Judge](https://leetcode.com/problems/find-the-town-judge/)                                              | Indegree logic               |
| 3   | [Graph Valid Tree](https://leetcode.com/problems/graph-valid-tree/)                                                    | Tree = Acyclic + Connected   |
| 4   | [Flood Fill](https://leetcode.com/problems/flood-fill/)                                                                | DFS/BFS in 2D Grid           |
| 5   | [Rotting Oranges](https://leetcode.com/problems/rotting-oranges/)                                                      | BFS in 2D Grid               |
| 6   | [Max Area of Island](https://leetcode.com/problems/max-area-of-island/)                                                | DFS Grid                     |
| 7   | [Island Perimeter](https://leetcode.com/problems/island-perimeter/)                                                    | Grid Count Logic             |
| 8   | [01 Matrix](https://leetcode.com/problems/01-matrix/)                                                                  | BFS from all 0s              |
| 9   | [Number of Connected Components](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/) | DFS/BFS/DSU                  |
| 10  | [Clone Graph](https://leetcode.com/problems/clone-graph/)                                                              | DFS/BFS Copy                 |
| 11  | [Surrounded Regions](https://leetcode.com/problems/surrounded-regions/)                                                | DFS Flood Fill               |
| 12  | [Count Sub Islands](https://leetcode.com/problems/count-sub-islands/)                                                  | DFS with Grid Comparison     |
| 13  | [Find Center of Star Graph](https://leetcode.com/problems/find-center-of-star-graph/)                                  | Edge Observation             |
| 14  | [Minimum Number of Vertices](https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/)             | Indegree=0                   |
| 15  | [Check Bipartite Graph](https://www.geeksforgeeks.org/bipartite-graph/)                                                | BFS/DFS 2-coloring           |
| 16  | [Transitive Closure of Graph](https://www.geeksforgeeks.org/transitive-closure-of-a-graph-using-dfs/)                  | DFS                          |
| 17  | [Detect Cycle (Directed)](https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1)              | Recursion Stack              |
| 18  | [Detect Cycle (Undirected)](https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1)         | DFS + parent check           |
| 19  | [Shortest Path in Unweighted Graph](https://www.geeksforgeeks.org/shortest-path-unweighted-graph/)                     | BFS                          |
| 20  | [Check if Graph is Tree](https://www.geeksforgeeks.org/check-given-graph-tree/)                                        | DFS + edge count             |
| 21  | [Detect Capital](https://leetcode.com/problems/detect-capital/)                                                        | Non-graph (mental break)     |
| 22  | [Employee Importance](https://leetcode.com/problems/employee-importance/)                                              | DFS/BFS on graph             |
| 23  | [Find if Path Exists](https://leetcode.com/problems/find-if-path-exists-in-graph/)                                     | DFS/BFS                      |
| 24  | [Shortest Path in Binary Matrix](https://leetcode.com/problems/shortest-path-in-binary-matrix/)                        | BFS 8-direction              |
| 25  | [Nearest Exit in Maze](https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/)                              | BFS from entry               |
| 26  | [Number of Islands](https://leetcode.com/problems/number-of-islands/)                                                  | DFS Grid                     |
| 27  | [All Paths from Source to Target](https://leetcode.com/problems/all-paths-from-source-to-target/)                      | DFS backtracking             |
| 28  | [Path Sum III](https://leetcode.com/problems/path-sum-iii/)                                                            | DFS in Tree                  |
| 29  | [Find the Judge](https://practice.geeksforgeeks.org/problems/find-the-judge/1)                                         | Array-based Indegree         |
| 30  | [BFS Traversal of Graph](https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1)                         | Basic Queue BFS              |
| 31  | [DFS Traversal of Graph](https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1)              | Recursion                    |
| 32  | [Topological Sort (Kahn)](https://practice.geeksforgeeks.org/problems/topological-sort/1)                              | Indegree BFS                 |
| 33  | [Detect Cycle using BFS](https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1)            | BFS with parent check        |
| 34  | [Mother Vertex in Graph](https://practice.geeksforgeeks.org/problems/mother-vertex/1)                                  | DFS postorder                |
| 35  | [DFS of Graph (Disconnected)](https://practice.geeksforgeeks.org/problems/dfs-of-graph/1)                              | Multiple Components          |
| 36  | [Union of Two Graphs](https://practice.geeksforgeeks.org/problems/union-of-two-graphs/1)                               | Graph Merge                  |
| 37  | [DFS Traversal on 2D Matrix](https://practice.geeksforgeeks.org/problems/number-of-distinct-islands/1)                 | DFS Shape Normalization      |
| 38  | [Number of Enclaves](https://leetcode.com/problems/number-of-enclaves/)                                                | Border DFS                   |
| 39  | [Open the Lock](https://leetcode.com/problems/open-the-lock/)                                                          | BFS                          |
| 40  | [Keys and Rooms](https://leetcode.com/problems/keys-and-rooms/)                                                        | DFS Graph Reachability       |
| 41  | [Ladder Length (Word Ladder)](https://leetcode.com/problems/word-ladder/)                                              | BFS on word graph            |
| 42  | [Friend Circles](https://leetcode.com/problems/friend-circles/)                                                        | Same as Provinces (Alt Name) |

##

## GRAPH DSA – MEDIUM LEVEL MASTERLIST (50 Problems)

#### BFS / DFS / Graph Traversal

| #   | Problem                                                                                           | Concept                         |
| --- | ------------------------------------------------------------------------------------------------- | ------------------------------- |
| 1   | [Course Schedule](https://leetcode.com/problems/course-schedule/)                                 | Topological Sort + Cycle Check  |
| 2   | [Course Schedule II](https://leetcode.com/problems/course-schedule-ii/)                           | Topological Sort + Order Output |
| 3   | [Pacific Atlantic Water Flow](https://leetcode.com/problems/pacific-atlantic-water-flow/)         | DFS from Multiple Sources       |
| 4   | [Open the Lock](https://leetcode.com/problems/open-the-lock/)                                     | BFS on State Space              |
| 5   | [Keys and Rooms](https://leetcode.com/problems/keys-and-rooms/)                                   | DFS Graph Reachability          |
| 6   | [Eventual Safe States](https://leetcode.com/problems/find-eventual-safe-states/)                  | Reverse DFS + Cycle Detection   |
| 7   | [All Paths from Source to Target](https://leetcode.com/problems/all-paths-from-source-to-target/) | DFS Backtracking                |
| 8   | [Evaluate Division](https://leetcode.com/problems/evaluate-division/)                             | DFS/BFS on Weighted Graph       |
| 9   | [Find if Path Exists in Graph](https://leetcode.com/problems/find-if-path-exists-in-graph/)       | DFS/BFS                         |
| 10  | [Graph Valid Tree](https://leetcode.com/problems/graph-valid-tree/)                               | Tree = Acyclic + Connected      |
| 11  | [Reconstruct Itinerary](https://leetcode.com/problems/reconstruct-itinerary/)                     | Hierholzer’s Algorithm          |
| 12  | [Word Ladder](https://leetcode.com/problems/word-ladder/)                                         | BFS on Word Graph               |
| 13  | [Shortest Path in Binary Matrix](https://leetcode.com/problems/shortest-path-in-binary-matrix/)   | BFS in 2D Grid                  |
| 14  | [Number of Enclaves](https://leetcode.com/problems/number-of-enclaves/)                           | Border DFS                      |
| 15  | [Walls and Gates](https://leetcode.com/problems/walls-and-gates/)                                 | Multi-source BFS                |

---

#### Shortest Paths

| #   | Problem                                                                                                                                                       | Concept                     |
| --- | ------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------- |
| 16  | [Network Delay Time](https://leetcode.com/problems/network-delay-time/)                                                                                       | Dijkstra Algorithm          |
| 17  | [Path with Minimum Effort](https://leetcode.com/problems/path-with-minimum-effort/)                                                                           | Min Heap (Dijkstra Variant) |
| 18  | [Cheapest Flights Within K Stops](https://leetcode.com/problems/cheapest-flights-within-k-stops/)                                                             | BFS + Priority Queue        |
| 19  | [Find the City with Smallest Number of Neighbors](https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/) | Floyd-Warshall Algorithm    |
| 20  | [Maze II](https://leetcode.com/problems/the-maze-ii/)                                                                                                         | BFS with Min Cost           |
| 21  | [Minimum Effort Path](https://leetcode.com/problems/path-with-minimum-effort/)                                                                                | Min Heap (Dijkstra Variant) |

---

#### Disjoint Set Union (DSU)

| #   | Problem                                                                                                      | Concept                      |
| --- | ------------------------------------------------------------------------------------------------------------ | ---------------------------- |
| 22  | [Redundant Connection](https://leetcode.com/problems/redundant-connection/)                                  | DSU Cycle Detection          |
| 23  | [Accounts Merge](https://leetcode.com/problems/accounts-merge/)                                              | DSU with String Matching     |
| 24  | [Similar String Groups](https://leetcode.com/problems/similar-string-groups/)                                | DSU with String Similarity   |
| 25  | [Satisfiability of Equality Equations](https://leetcode.com/problems/satisfiability-of-equality-equations/)  | DSU with Boolean Logic       |
| 26  | [Largest Component by Common Factor](https://leetcode.com/problems/largest-component-size-by-common-factor/) | DSU with Prime Factorization |

---

#### Topological Sort & DAG

| #   | Problem                                                                                        | Concept                        |
| --- | ---------------------------------------------------------------------------------------------- | ------------------------------ |
| 27  | [Alien Dictionary](https://practice.geeksforgeeks.org/problems/alien-dictionary/1)             | Topological Sort + Cycle Check |
| 28  | [Parallel Courses](https://leetcode.com/problems/parallel-courses/)                            | Topological Sort               |
| 29  | [Minimum Semesters to Finish Courses](https://leetcode.com/problems/parallel-courses-ii/)      | Topological Sort + Bitmask     |
| 30  | [Minimum Height Trees](https://leetcode.com/problems/minimum-height-trees/)                    | Tree Center Finding            |
| 31  | [Longest Path in DAG](https://www.geeksforgeeks.org/find-longest-path-directed-acyclic-graph/) | DAG Longest Path               |
| 32  | [Sequence Reconstruction](https://leetcode.com/problems/sequence-reconstruction/)              | Topological Sort + Sequence    |

---

#### Trees as Graphs / Special Cases

| #   | Problem                                                                                           | Concept                    |
| --- | ------------------------------------------------------------------------------------------------- | -------------------------- |
| 33  | [Tree Diameter](https://leetcode.com/problems/diameter-of-binary-tree/)                           | DFS on Tree                |
| 34  | [Sum of Distances in Tree](https://leetcode.com/problems/sum-of-distances-in-tree/)               | Tree DP                    |
| 35  | [Longest Univalue Path](https://leetcode.com/problems/longest-univalue-path/)                     | DFS with Value Matching    |
| 36  | [Distribute Coins in Binary Tree](https://leetcode.com/problems/distribute-coins-in-binary-tree/) | DFS with State Propagation |
| 37  | [Binary Tree Cameras](https://leetcode.com/problems/binary-tree-cameras/)                         | Greedy DFS                 |

---

#### Grid Graphs (BFS/DFS)

| #   | Problem                                                                                                | Concept                 |
| --- | ------------------------------------------------------------------------------------------------------ | ----------------------- |
| 38  | [Escape the Ghosts](https://leetcode.com/problems/escape-the-ghosts/)                                  | Manhattan Distance      |
| 39  | [Cut Off Trees for Golf Event](https://leetcode.com/problems/cut-off-trees-for-golf-event/)            | Multi-source BFS        |
| 40  | [As Far from Land as Possible](https://leetcode.com/problems/as-far-from-land-as-possible/)            | BFS in 2D Grid          |
| 41  | [Number of Distinct Islands](https://practice.geeksforgeeks.org/problems/number-of-distinct-islands/1) | DFS Shape Normalization |
| 42  | [Word Search](https://leetcode.com/problems/word-search/)                                              | DFS Backtracking        |

---

#### Conceptual / Observation Based

| #   | Problem                                                                                                                     | Concept                |
| --- | --------------------------------------------------------------------------------------------------------------------------- | ---------------------- |
| 43  | [Snakes and Ladders](https://leetcode.com/problems/snakes-and-ladders/)                                                     | BFS on Board Game      |
| 44  | [Jump Game IV](https://leetcode.com/problems/jump-game-iv/)                                                                 | BFS with State Pruning |
| 45  | [Minimum Moves to Reach Target with Rotations](https://leetcode.com/problems/minimum-moves-to-reach-target-with-rotations/) | BFS with Grid State    |
| 46  | [The Maze](https://leetcode.com/problems/the-maze/)                                                                         | BFS with Rolling Ball  |
| 47  | [Bus Routes](https://leetcode.com/problems/bus-routes/)                                                                     | BFS on Route Graph     |
| 48  | [Minimum Genetic Mutation](https://leetcode.com/problems/minimum-genetic-mutation/)                                         | BFS on Mutation Graph  |
| 49  | [Stepping Numbers](https://www.geeksforgeeks.org/stepping-numbers/)                                                         | BFS on Number Graph    |
| 50  | [Bipartite Check (Coloring)](https://leetcode.com/problems/is-graph-bipartite/)                                             | BFS/DFS 2-coloring     |

##

## GRAPH DSA – HARD LEVEL MASTERLIST (30 Problems)

| #   | Problem                                                                                                                                           | Core Concept                   |
| --- | ------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------ |
| 1   | [Word Ladder II](https://leetcode.com/problems/word-ladder-ii/)                                                                                   | BFS with Backtracking          |
| 2   | [Jump Game IV](https://leetcode.com/problems/jump-game-iv/)                                                                                       | BFS + Hashing                  |
| 3   | [Count All Paths with Min Cost](https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/)                                           | Dijkstra Variant               |
| 4   | [Path with Maximum Probability](https://leetcode.com/problems/path-with-maximum-probability/)                                                     | Dijkstra (Product)             |
| 5   | [Minimum Cost Path with Directions](https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/)                        | 0-1 BFS                        |
| 6   | [The Maze II](https://leetcode.com/problems/the-maze-ii/)                                                                                         | BFS with Min Cost              |
| 7   | [The Maze III](https://leetcode.com/problems/the-maze-iii/)                                                                                       | BFS + Lexicographic order      |
| 8   | [Minimum Jumps to Reach Home](https://leetcode.com/problems/minimum-jumps-to-reach-home/)                                                         | BFS with visited state pruning |
| 9   | [Shortest Path Visiting All Nodes](https://leetcode.com/problems/shortest-path-visiting-all-nodes/)                                               | Bitmask BFS                    |
| 10  | [Cheapest Flights with K Stops](https://leetcode.com/problems/cheapest-flights-within-k-stops/)                                                   | BFS + PriorityQueue            |
| 11  | [Reconstruct Itinerary](https://leetcode.com/problems/reconstruct-itinerary/)                                                                     | Hierholzer’s Algo              |
| 12  | [Parallel Courses II](https://leetcode.com/problems/parallel-courses-ii/)                                                                         | Bitmask + Topo                 |
| 13  | [Swim in Rising Water](https://leetcode.com/problems/swim-in-rising-water/)                                                                       | Min Heap (Dijkstra variant)    |
| 14  | [Cut Off Trees for Golf Event](https://leetcode.com/problems/cut-off-trees-for-golf-event/)                                                       | Multi-source BFS               |
| 15  | [Minimum Time to Collect All Apples](https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/)                                 | DFS + Tree pruning             |
| 16  | [Find Critical and Pseudo-Critical Edges in MST](https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/) | MST Variants                   |
| 17  | [Critical Connections in a Network](https://leetcode.com/problems/critical-connections-in-a-network/)                                             | Tarjan’s Algo                  |
| 18  | [Articulation Points](https://www.geeksforgeeks.org/articulation-points-or-cut-vertices-in-a-graph/)                                              | DFS TimeIn/Low                 |
| 19  | [Bridges in Graph (Tarjan’s)](https://www.geeksforgeeks.org/bridge-in-a-graph/)                                                                   | DFS + Bridge Detection         |
| 20  | [Kosaraju’s Algorithm (SCC)](https://www.geeksforgeeks.org/strongly-connected-components/)                                                        | Reverse DFS                    |
| 21  | [Alien Dictionary (Hard)](https://leetcode.com/problems/alien-dictionary/)                                                                        | Topo + Cycle Detection         |
| 22  | [Dijkstra + Max Probability](https://leetcode.com/problems/path-with-maximum-probability/)                                                        | Priority Queue                 |
| 23  | [Constrained Subsequence Sum](https://leetcode.com/problems/constrained-subsequence-sum/)                                                         | Monotonic Queue DP             |
| 24  | [Avoid Flood in the City](https://leetcode.com/problems/avoid-flood-in-the-city/)                                                                 | Map + Greedy + TreeSet         |
| 25  | [Minimum Moves to Reach Target with Rotations](https://leetcode.com/problems/minimum-moves-to-reach-target-with-rotations/)                       | BFS with grid state            |
| 26  | [Bipartite Graph Check (Hard)](https://leetcode.com/problems/is-graph-bipartite/)                                                                 | 2-color check                  |
| 27  | [Race Car](https://leetcode.com/problems/race-car/)                                                                                               | BFS with visited states        |
| 28  | [Network Delay Time (Advanced)](https://leetcode.com/problems/network-delay-time/)                                                                | Heap Dijkstra                  |
| 29  | [Distribute Water in a Village](https://leetcode.com/problems/optimize-water-distribution-in-a-village/)                                          | Kruskal with Virtual Node      |
| 30  | [Max Points in Grid with Steps](https://leetcode.com/problems/maximum-number-of-points-with-cost/)                                                | Graph-like DP                  |

##

## GRAPH DSA – EXTREME LEVEL PROBLEMS (10 Problems)

| #   | Problem                                                                                                                                                           | Core Concepts                      |
| --- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------- |
| 1   | [Alien Dictionary (Hard - Unique Order)](https://leetcode.com/problems/alien-dictionary/)                                                                         | Topological Sort + Cycle Detection |
| 2   | [Parallel Courses III](https://leetcode.com/problems/parallel-courses-iii/)                                                                                       | DAG + Longest Path + DFS           |
| 3   | [Strongly Connected Components (Kosaraju/Tarjan)](https://leetcode.com/problems/longest-cycle-in-a-graph/)                                                        | Kosaraju + Cycle Length            |
| 4   | [Maximum Number of Non-Overlapping Paths](https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/)                                           | DAG Topo + Graph Dependency        |
| 5   | [Minimum Incompatibility](https://leetcode.com/problems/minimum-incompatibility/)                                                                                 | Bitmask DP + Graph Coloring        |
| 6   | [Minimum Cost to Make at Least One Valid Path](https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/)                             | 0-1 BFS + Directional Edges        |
| 7   | [Maximum Path Quality of a Graph](https://leetcode.com/problems/maximum-path-quality-of-a-graph/)                                                                 | DFS with Time Limit Pruning        |
| 8   | [Minimum Number of Increments on Subarrays to Form Target Array](https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/) | Segment Tree + Graph Insight       |
| 9   | [Minimum Number of Vertices to Reach All Nodes](https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/)                                     | DAG + Indegree Analysis            |
| 10  | [2-SAT Problem (Implication Graph)](https://www.geeksforgeeks.org/two-satisfiability-2-sat-problem/)                                                              | SCC + Boolean Formula Graph        |
