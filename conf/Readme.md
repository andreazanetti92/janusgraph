# Launch Janus Server 
In this folder is set 2 yaml configuration in order to run an janusgraph server. Plus there is a properties file used by both of the yaml files when launch janus server.

## YAML File Internals
### Now we highligthing all the important parts:

The yaml file start with declaring which **host** and **port** can connect to janus server.    
In this examples we provide the IP Address 0.0.0.0 that can connect, that means all hosts can connect. The port exposed is the 8182, the default one.    

Another property we found is **Channlizer** that specify which protocol to use (WebSocket, Http or Both):
```
org.apache.tinkerpop.gremlin.server.channel.WsAndHttpChannelizer
```
```
org.apache.tinkerpop.gremlin.server.channel.WebSocketChannelizer
```
```
org.apache.tinkerpop.gremlin.server.channel.HttpChannelizer
```
<br>


Then we find the ***graphs*** properties where we passing a .properties file that set the a graph instance and set vertex id manager as long (that allows you to work with ids as int). Example of tinkergraph-empty.properties:
```
gremlin.graph=org.apache.tinkerpop.gremlin.tinkergraph.structure.TinkerGraph
gremlin.tinkergraph.vertexIdManager=LONG
```
<br>
In the scriptEngines section we define the plugins used by gremlin server:      

**NB:** The last plugin of the list is the one that allow us to run our air-routes.groovy script, that it's passed as arguments:
```
scriptEngines: {
  gremlin-groovy: {
    plugins: { 
               org.apache.tinkerpop.gremlin.server.jsr223.GremlinServerGremlinPlugin: {},
               org.apache.tinkerpop.gremlin.tinkergraph.jsr223.TinkerGraphGremlinPlugin: {},
               org.apache.tinkerpop.gremlin.groovy.jsr223.GroovyCompilerGremlinPlugin: {enableThreadInterrupt: true},
               org.apache.tinkerpop.gremlin.jsr223.ImportGremlinPlugin: {classImports: [java.lang.Math], methodImports: [java.lang.Math#*]},
              org.apache.tinkerpop.gremlin.jsr223.ScriptFileGremlinPlugin: {files: [scripts/air-routes.groovy]}
               }}}
```
<br>

**The air-routes.groovy scripts:**    
It's read onStartup the air-routes.graphml file and set the GraphTraversalSource to "g" and exposing it globally:


```
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
```
**NB**: In order to really expose the g and allow to being called by an external application it's manadatory that there is a file **scripts/remote-connect.groovy** that connect to the tinkerpop.server and the call the g:
```
:remote connect tinkerpop.server conf/remote.yaml
:> g
```

<br>

The next section is the **serializers** in which we define the various file serializers used by gremlin server.

The last section is the **processors** that define the processors used by gremlin server.


<br>
<br>

## Gremlin Server air routes
After launched the containers with:
```
docker-compose up -d
```

Run the command: 
```
docker exec -it jce-janusgraph bin/janusgraph-server.sh conf/gremlin-server-air-routes.yaml
```
This command tell to janus to launch the server with the configurations passed as parameters.

After this, you are able to use the existing air routes graph database within your application (in C#, Golang, Python, NodeJS).

## Gremlin server nuboj dev
After launched the containers with:
```
docker-compose up -d
```

Run the command: 
```
docker exec -it jce-janusgraph bin/janusgraph-server.sh conf/gremlin-server-nuboj-dev.yaml
```
This command tell to janus to launch the server with the configurations passed as parameters.

After this, you are able to use the existing nuboj dev graph database within your application (in C#, Golang, Python, NodeJS).
