# election-distributed-system
A Java-based distributed election system implementing a client–server architecture with a shared remote interface.

## Overview
This project implements a **distributed election system** in Java using a **client–server architecture** with a shared interface.

Clients interact with a central server to cast votes and retrieve election results. The system demonstrates key concepts from **distributed systems**, including remote communication, shared contracts, and server-side state management.

## Architecture
- **Client**
  - Connects to the election server
  - Submits votes
  - Requests election results
- **Server**
  - Maintains election state
  - Processes client requests
  - Enforces election rules
- **Shared Interface**
  - Defines the remote methods exposed by the server
  - Acts as a contract between client and server

## Technologies Used
- **Language:** Java
- **Concepts:** Distributed systems, client–server architecture, remote interfaces
- **Design:** Interface-driven communication

## Project Structure
- `client/` – Client-side application
- `server/` – Server-side implementation
- `shared/` – Shared election interface

## How It Works
1. The server initializes the election and waits for client requests
2. Clients connect to the server using the shared interface
3. Clients submit votes or request results
4. The server updates and returns election data accordingly

## How to Run
1. Start the election server
2. Launch one or more clients
3. Cast votes and retrieve election results through the client interface

(Exact startup steps depend on the communication mechanism used.)

## Academic Context
This project was developed to practice:
- Distributed system design
- Client–server coordination
- Interface-based communication
- Remote method invocation concepts

## Author
Franck Dipanda
