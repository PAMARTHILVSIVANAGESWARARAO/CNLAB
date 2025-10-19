# Computer Networks Programs

This repository contains Java implementations of various algorithms and protocols commonly studied in Computer Networks. Each program demonstrates key concepts in data link layer, transport layer, and network layer functionalities. Below is a detailed explanation of each Java program, including what it does, key concepts involved, how to run it, and expected inputs/outputs.

## 1. BitStuffing.java
**Description**: This program demonstrates bit stuffing, a technique used in the data link layer to ensure that a sequence of bits does not contain a flag pattern that could be mistaken for a frame delimiter.

**Key Concepts**:
- Framing: Bit stuffing inserts an extra '0' after five consecutive '1's to prevent accidental flag detection.
- Data Link Layer: Ensures reliable data transmission by avoiding delimiter confusion.

**How to Run**:
- Compile: `javac BitStuffing.java`
- Run: `java BitStuffing`
- The program uses a hardcoded string "01110111011111011111" for stuffing and unstuffs "011101110111110111110".

**Inputs/Outputs**:
- Input: Hardcoded bit string.
- Output: Stuffed and unstuffed versions of the bit string.

## 2. CharacterStuffing.java
**Description**: This program implements character stuffing (also known as byte stuffing), used to handle special characters in data frames by escaping them.

**Key Concepts**:
- Framing: Inserts escape characters ('F') before special characters ('E' or 'F') to distinguish them from delimiters.
- Data Link Layer: Prevents misinterpretation of control characters in data.

**How to Run**:
- Compile: `javac CharacterStuffing.java`
- Run: `java CharacterStuffing`
- Uses a hardcoded string "DEFGAEEFEFH" for demonstration.

**Inputs/Outputs**:
- Input: Hardcoded string.
- Output: Stuffed and unstuffed versions of the string.

## 3. Checksum.java
**Description**: This program calculates and verifies checksums for error detection in data transmission. It divides the data into blocks, computes the sum, and checks for errors at the receiver.

**Key Concepts**:
- Error Detection: Uses one's complement addition to detect transmission errors.
- Data Integrity: Ensures data has not been corrupted during transfer.

**How to Run**:
- Compile: `javac Checksum.java`
- Run: `java Checksum`
- Prompts for string length, data bits, and block size.

**Inputs/Outputs**:
- Input: Length of boolean string, the string itself, block size.
- Output: Divided blocks, checksum, and error detection result (no error or error detected).

## 4. HammingCode.java
**Description**: Implements Hamming code for error detection and correction. It generates parity bits and can correct single-bit errors.

**Key Concepts**:
- Error Correction: Adds redundant bits to detect and correct errors.
- Hamming Distance: Ensures codes differ by at least two bits for error detection.

**How to Run**:
- Compile: `javac HammingCode.java`
- Run: `java HammingCode`
- Prompts for number of data bits and the data bits.

**Inputs/Outputs**:
- Input: Number of data bits, data bits, received message.
- Output: Generated Hamming code, error position (if any), and corrected message.

## 5. CRC.java
**Description**: This program implements Cyclic Redundancy Check (CRC) for error detection using polynomial division.

**Key Concepts**:
- Error Detection: Uses generator polynomial to compute remainder (CRC bits).
- Data Link Layer: Detects burst errors in transmitted frames.

**How to Run**:
- Compile: `javac CRC.java`
- Run: `java CRC`
- Prompts for frame size, frame bits, generator polynomial degree, and coefficients.

**Inputs/Outputs**:
- Input: Frame size, frame bits, generator coefficients, received frame.
- Output: CRC bits, transmitted frame, remainder, and error status.

## 6. StopAndWaitProtocol.java
**Description**: Simulates the Stop-and-Wait Automatic Repeat Request (ARQ) protocol, where the sender waits for acknowledgment before sending the next frame.

**Key Concepts**:
- ARQ Protocols: Ensures reliable data transfer with acknowledgments and timeouts.
- Flow Control: Prevents buffer overflow by limiting outstanding frames to one.

**How to Run**:
- Compile: `javac StopAndWaitProtocol.java`
- Run: `java StopAndWaitProtocol`
- Prompts for total number of frames.

**Inputs/Outputs**:
- Input: Total frames, acknowledgment responses (y/n).
- Output: Frame sending status, acknowledgments, timeouts, and resends.

## 7. GoBackNARQ.java
**Description**: Implements the Go-Back-N ARQ protocol, allowing multiple frames to be sent before waiting for acknowledgments, and retransmitting from the lost frame on error.

**Key Concepts**:
- Sliding Window: Uses a window size for pipelining frames.
- Efficiency: Improves throughput over Stop-and-Wait by sending multiple frames.

**How to Run**:
- Compile: `javac GoBackNARQ.java`
- Run: `java GoBackNARQ`
- Prompts for total frames and window size.

**Inputs/Outputs**:
- Input: Total frames, window size, acknowledgment responses.
- Output: Frame sending, acknowledgments, timeouts, and retransmissions.

## 8. SelectiveRepeatProtocol.java
**Description**: Simulates Selective Repeat ARQ, where only the erroneous frame is retransmitted, not all subsequent frames.

**Key Concepts**:
- Selective Retransmission: Reduces bandwidth waste by retransmitting only lost frames.
- Sliding Window: Maintains a window for out-of-order acknowledgments.

**How to Run**:
- Compile: `javac SelectiveRepeatProtocol.java`
- Run: `java SelectiveRepeatProtocol`
- Prompts for total frames and window size.

**Inputs/Outputs**:
- Input: Total frames, window size, acknowledgment responses.
- Output: Frame sending, acknowledgments, and selective resends.

## 9. LeakyBucket.java
**Description**: Implements the Leaky Bucket algorithm for traffic shaping, regulating packet transmission rate to prevent network congestion.

**Key Concepts**:
- Traffic Shaping: Smooths bursty traffic by limiting output rate.
- Congestion Control: Uses a bucket with a leak rate to process packets.

**How to Run**:
- Compile: `javac LeakyBucket.java`
- Run: `java LeakyBucket`
- Prompts for bucket capacity and leak rate, then incoming packets.

**Inputs/Outputs**:
- Input: Capacity, leak rate, incoming packets (enter -1 to stop).
- Output: Packets added/dropped, leaked packets, buffer size.

## 10. Dijkstra.java
**Description**: Implements Dijkstra's algorithm to find the shortest path between nodes in a graph, useful for routing in networks.

**Key Concepts**:
- Shortest Path: Uses priority queue to find minimum cost paths.
- Routing Algorithms: Basis for link-state routing protocols.

**How to Run**:
- Compile: `javac Dijkstra.java`
- Run: `java Dijkstra`
- Prompts for vertices, edges, weights, source, and destination.

**Inputs/Outputs**:
- Input: Number of vertices, vertex names, edges with weights, source, destination.
- Output: Shortest path and total cost.

## 11. DistanceVectorRouting.java
**Description**: Simulates Distance Vector Routing, where routers exchange routing tables to compute shortest paths using Bellman-Ford equation.

**Key Concepts**:
- Routing Protocols: RIP uses distance vectors for path computation.
- Dynamic Routing: Updates tables iteratively to reflect network changes.

**How to Run**:
- Compile: `javac DistanceVectorRouting.java`
- Run: `java DistanceVectorRouting`
- Prompts for number of nodes, adjacency matrix, source, destination.

**Inputs/Outputs**:
- Input: Number of nodes, adjacency matrix, source, destination.
- Output: Routing tables, path from source to destination.

## 12. BroadcastTree.java
**Description**: Constructs a Broadcast Tree using Prim's algorithm (Minimum Spanning Tree) for efficient broadcasting in a subnet.

**Key Concepts**:
- Spanning Tree: Connects all nodes with minimum cost edges.
- Broadcasting: Ensures message reaches all hosts with minimal redundancy.

**How to Run**:
- Compile: `javac BroadcastTree.java`
- Run: `java BroadcastTree`
- Prompts for number of hosts, adjacency matrix, subnet hosts.

**Inputs/Outputs**:
- Input: Number of hosts, adjacency matrix, subnet indices.
- Output: Broadcast tree edges and total cost.

## Requirements
- Java Development Kit (JDK) installed.
- Run programs in a terminal or IDE supporting Java.

## Notes
- All programs use console input/output for simplicity.
- Hardcoded values are used in some programs for demonstration; modify as needed.
- These implementations are educational and may not handle all edge cases for production use.
