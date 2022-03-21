// ##########################################################################
// IT'S USED BY GREMLIN-SERVER-AIR-ROUTES.YAML TO LOAD THE AIR-ROUTES.GRAPHML
// ##########################################################################

// an init script that returns a Map allows explicit setting of global bindings.
def globals = [:]

// Generates the classic graph into an "empty" TinkerGraph via LifeCycleHook.
// Note that the name of the key in the "global" map is unimportant.
globals << [hook : [
  onStartUp: { ctx ->
    ctx.logger.info("Loading 'air-routes' graph data.")
    graph.io(graphml()).readGraph('mydata/air-routes.graphml')
  }
] as LifeCycleHook]

// define the default TraversalSource to bind queries to - this one will be named "g".
globals << [g : graph.traversal()]