
# Server Starter Application

## Overview
This application is designed to initialize and start a series of servers based on configurations specified in a YAML file. It provides a simple yet effective way to manage server startups dynamically using external configuration. The project will evolve further to demonstrate the heartbeat mechanism which is used in distributed systems.

## Main Features
- **Dynamic Server Configuration**: Configure server settings such as type and the number of instances through a `config.yaml` file.
- **Automatic Server Initialization**: Automatically initializes servers based on the configuration and starts them.

## How It Works
The `Main` class includes the main method that kicks off the server startup process:
- It loads server configuration details from a YAML file.
- It retrieves server types and their respective instances.
- It initializes and starts each server accordingly.

### Method `startServers()`
This method handles the initialization and starting of the servers by:
1. Loading server configuration details.
2. Retrieving each server's type and required instances from the configuration.
3. Fetching and starting each server based on the provided configuration.

### Configuration File
Server configurations are specified in `config.yaml`. This file should be structured to define each server type and its required number of instances.

## Setup and Running
1. Ensure Java and Maven are properly installed on your system.
2. Place your `config.yaml` in the same directory as the `Main` class or adjust the path in the code accordingly.
3. Compile and run the application.

## Contributing
Feel free to fork this project and submit pull requests. You can also open issues if you find bugs or have feature requests.

## License
This project is licensed under the MIT License - see the LICENSE file for details.
