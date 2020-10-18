## blockly xml解析器

#### <block>

- block对象由两部分组成

- **block** 和 **blockSvg**
  - 分别于用于存储数据和svg渲染



#### 自定义块

- json文件
  - type
  - message
  - args0
  - color
  - tooltip
  - helpUrl



#### block -> xml 的转换

- 以下一个block为例子（来源：[Google demos](https://blockly-demo.appspot.com/static/demos/index.html)）
- ![1](img\1.png)

对应的xml文档如下

```xml
<xml xmlns="https://developers.google.com/blockly/xml">
  <block type="controls_if" inline="false" x="20" y="20">
    <mutation else="1"></mutation>
    <value name="IF0">
      <block type="logic_compare" inline="true">
        <field name="OP">EQ</field>
        <value name="A">
          <block type="math_arithmetic" inline="true">
            <field name="OP">MULTIPLY</field>
            <value name="A">
              <block type="math_number">
                <field name="NUM">6</field>
              </block>
            </value>
            <value name="B">
              <block type="math_number">
                <field name="NUM">7</field>
              </block>
            </value>
          </block>
        </value>
        <value name="B">
          <block type="math_number">
            <field name="NUM">42</field>
          </block>
        </value>
      </block>
    </value>
    <statement name="DO0">
      <block type="text_print" inline="false">
        <value name="TEXT">
          <block type="text">
            <field name="TEXT">Don't panic</field>
          </block>
        </value>
      </block>
    </statement>
    <statement name="ELSE">
      <block type="text_print" inline="false">
        <value name="TEXT">
          <block type="text">
            <field name="TEXT">Panic</field>
          </block>
        </value>
      </block>
    </statement>
  </block>
</xml>
        
```

可以看出，同行的代码块满足着相互嵌套的基本逻辑模式

例如：**multiply操作**

- 代码如下：

- ```xml
  		<block type="math_arithmetic" inline="true">
              <field name="OP">MULTIPLY</field>
              <value name="A">
                <block type="math_number">
                  <field name="NUM">6</field>
                </block>
              </value>
              <value name="B">
                <block type="math_number">
                  <field name="NUM">7</field>
                </block>
              </value>
            </block>
          </value>
          <value name="B">
            <block type="math_number">
              <field name="NUM">42</field>
            </block>
          </value>
        </block>
  ```

- 最外层包裹着一个名为**multiply**的<block>，可以看作是整个操作的输出

- 下级并列存放着多个块，以下逐一解释

  - field 应该表示一个**可填入**的数据类型，即可选择的数据类型
  - value 表示传入值。与field的区别在于，value表示着输出/获得值这一行为

整个if语句共分成了4部分

```xml
 <block type="controls_if" inline="false" x="20" y="20">
    <mutation else="1"></mutation>
    <value name="IF0">
    </value>
    <statement name="DO0">
    </statement>
    <statement name="ELSE">
    </statement>
  </block>
```

- 我们可以简单地发现：
  - mutation 块中的**else元素**指向了该if语句的分支的else的数目，当else=0时，生成的代码块不具有else分支，生成的代码中不具有else语句
  - value块-name: IF0 表示**IF语句的条件**，0应该表示为第一个条件，由于该IF语句只有一个条件，因此0并没有任何实际意义
  - DO0、ELSE0与IF0同理



我们大致可以得出，处于同一代码块（例如例子中的controls_if）下，以**操作流形式存在的代码块**，会在block中依照顺序**并列排列**，并且**关于数量的声明排列在操作之前**，以mutation块的形式呈现（这也是情有可原的）

而对于某一**产生输入输出的代码块**（例如multiply或者math_number），则会以value->block->field的链状嵌套模式排列，用特定的代码块（如value）以获得值。block标签本身只代表block块的客观存在，而不包含任何与其他块相互连接的概念。

上述代码块可扩展到复杂的操作中。

