# IO技术

- 数据源：提供数据的原始媒介，常见的：数据库、文件、其他程序、内存、网络连接、IO设备

- 以程序为中心界定输入输出

- 存在盘符--绝对路径，否则是相对路径（相对于user.dir）

- mkdir:创建文件夹 父目录不存在则失败

- mkdirs:创建文件夹 父目录不存在则创建父目录

- 所有输入输出都能转换为字节，但不是所有都能转换为字符

- FileInputStream..处理字节流 FileReader..处理字符流，源是硬盘，需要关闭（jvm通知os)

- ByteArrayInputStream..字节数组流，不需要关闭，由gc（垃圾回收机制）解决，方便进行网络上的传输

- 字节缓冲流：BufferedInputStream，其实就是装饰者设计模式的对InputStream的具体装饰类，内部维护了缓冲区，提高了读写的速率，建议加上

- BufferedReader：有很多新增方法，不要发生多态

- InputStreamReader：从字节流到字符流的桥梁，将字节流解码为字符

  OutputStreamWriter：将写入的字符编码为字节

- DataInputStream：保留了数据类型，先写出后读取，写出顺序和读取顺序一致

- 若面试问如何得到字节流的大小：ByteArrayOutputStream的toByteArray方法

- ObjectInputStream：反序列化，将对象读入；反之：序列化将对象写出（硬盘，内存，数据库）。

  先写出后读取，写出顺序和读取顺序一致。但不是所有对象都可以序列化，只有加Serializable才能被序列化（自定义的类）

  