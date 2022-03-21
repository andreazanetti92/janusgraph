// ##########################################################################################
// IT'S USED BY GREMLIN-SERVER-NUBOJ-DEV.YAML TO LOAD THE nuboj_dev_things_db_2022_03_11.json
// ##########################################################################################

// an init script that returns a Map allows explicit setting of global bindings.
def globals = [:]

// Generates the classic graph into an "empty" TinkerGraph via LifeCycleHook.
// Note that the name of the key in the "global" map is unimportant.
globals << [hook : [
  onStartUp: { ctx ->
    ctx.logger.info("Loading 'NUBOJ-DEV' graph data.")
    graph.io(graphson()).readGraph('mydata/nuboj_dev_things_db_2022_03_11.json')
  }
] as LifeCycleHook]

// define the default TraversalSource to bind queries to - this one will be named "g".
globals << [g : graph.traversal()]