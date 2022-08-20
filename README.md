# PluginArchitectureSample
Sample demo project to illustrate the plugin architecture

## Screens
There are two screens : a home screen which shows an animal list and a detail screen.

## Modules
There are five modules :
- app
- cat (plugin 1)
- dog (plugin 2)
- detail
- data

## Implementation
The plugins implement an interface exposed by the detail module.
This configuration helps modify dynamically the detail screen.