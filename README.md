# PhysicsSimulatorTP

A simulator is implemented for some laws of physics in a two-dimensional (2D) space. The simulator will have two main components:

Bodies, which represent physical entities (for example planets), which have a speed, acceleration, position and mass. These bodies, when requested, can move, modifying their position according to some physical laws.

Laws of force, which apply forces to bodies (for example, gravitational forces).

We will use an object-oriented design to be able to handle different classes of bodies and laws of forces. In addition, we will use generics to implement factories, both for bodies and for force laws.

A simulation step consists of initializing the force applied to each body, applying force laws to change the forces applied to the bodies, and then requesting each body to move. In this practice:

The input will be: (a) a file that describes a list of bodies in JSON format; (b) the laws of force to be used and; (c) the number of steps the simulator must execute.

The output will be a JSON structure that describes the state of the bodies at the beginning and after each step of the simulation.
In the resources directory you can find some examples of input files, with the corresponding output files.
