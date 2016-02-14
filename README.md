# simple_vector_math
Simple, not optimized, but working 2D-vector math.

<hr/>

## Getting the library

Simple commands to compile into local maven repository:

    git clone https://github.com/anttiraisala/simple_vector_math.git
    cd simple_vector_math
    mvn clean install -DskipTests=true

Maven depedency:

    <dependency>
      <groupId>simple-vector-math</groupId>
      <artifactId>essentials</artifactId>
      <version>1.0-SNAPSHOT</version
    </dependency>

## Features & code examples:

<table>
<tr>
<th><b>Feature / function</b></th>
<th><b>Code</b></th>
</tr>

<tr>
<td>Create vector from X & Y coordinates</td>
<td><pre>
Vector2 v1 = Vector2.ofXY(2.0, 3.0);
</pre></td>
</tr>

<tr>
<td>Create vector from polar coordinates<br>R = radius ( i.e. length )<br>A = angle in radians, counter clockwise</td>
<td><pre>
Vector2 v = Vector2.ofRA(2.5, RADIANS_IN_35_DEGREES);
</pre></td>
</tr>

<tr>
<td>add</td>
<td><pre>
Vector2 v1 = Vector2.ofXY(2.0, 3.0);
Vector2 v2 = Vector2.ofXY(4.0, 8.0);
Vector2 vResult = v1.add(v2);
</pre></td>
</tr>

<tr>
<td>subtract</td>
<td><pre>
Vector2 v1 = Vector2.ofXY(2.0, 3.0);
Vector2 v2 = Vector2.ofXY(4.0, 8.0);
Vector2 vResult = v1.subtract(v2);
</pre></td>
</tr>

<tr>
<td>scale ( multiply by scalar )</td>
<td><pre>
Vector2 v = Vector2.ofRA(2.5, RADIANS_IN_35_DEGREES);
Vector2 v2 = v.multiply(16.5);
</pre></td>
</tr>

</table>


#### Git-related links
###### git - the simple guide; just a simple guide for getting started with git. no deep shit ;)
http://rogerdudler.github.io/git-guide/
###### Markdown: Syntax
https://daringfireball.net/projects/markdown/syntax#header
