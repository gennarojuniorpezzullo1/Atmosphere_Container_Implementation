# Container-based Platform for Computational Medicine

## Overview

This project presents the implementation of a container-based platform for computational medicine, inspired by the Atmosphere cloud platform initially developed by ACK Cyfronet AGH. The redesigned platform leverages containerization technologies, specifically Kubernetes, to facilitate the deployment and management of scientific simulations in the field of computational medicine. This README provides instructions for setting up and using the platform, along with a brief description of its architecture and components.

## Project Structure

The project is organized into several key components:

Administrator Setup: Scripts and configurations for setting up the platform and Kubernetes cluster.
Developer Tools: Tools for creating and uploading services as containerized applications.
End-User Interface: A simplified command-line interface (CLI) for end-users to request, use, and terminate services.
Prerequisites

## To deploy and run this platform, ensure that the following software is installed:

Docker: Used to create and manage containers.
Minikube: A lightweight Kubernetes implementation for local development.
Maven: Used to manage Java dependencies and build the project.
Kubernetes CLI (kubectl): Command-line tool for interacting with Kubernetes clusters.
Java JDK 8 or higher: Required to run the Maven project.

##  Usage

### For Administrators
Administrators are responsible for the initial setup of the platform, including configuring the image repository and setting up the Kubernetes cluster. After the setup, administrators can monitor the platform's status and ensure that the services run smoothly.

### For Developers
Developers can create and upload services by packaging their applications into containers. These services are then deployed on the platform, where they can be accessed by end-users.

### For End-Users
End-users interact with the platform through a simple CLI. They can request services, use them, and terminate them when finished.

## Future Work

Administrator and Developer Interfaces: Extend the current setup with additional tools and interfaces to simplify administration and development tasks.
Web-based Frontend: Develop a web-based interface for end-users, similar to the original Atmosphere platform.
Semantic Extensions: Integrate semantic technologies to enable automatic composition of containers for specific simulation services.
Acknowledgements

We would like to thank Marek Kasztelnik, Maciej Malawski, Jan Meizner, and Piotr Nowakowski from ACC Cyfronet for their invaluable assistance and discussions regarding the Kubernetes setup. Special thanks to the Erasmus+ program for supporting this work.

# References

For detailed documentation, https://www.researchgate.net/publication/359624216_Container-Based_Platform_for_Computational_Medicine

