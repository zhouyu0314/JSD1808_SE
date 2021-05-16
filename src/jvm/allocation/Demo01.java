package jvm.allocation;

/**
 * -XX:+UseConcMarkSweepGC 使用cms
 */
public class Demo01 {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        //testAllocation();
        //testPretenureSizeThreshold();
        //testTenuringThreshold();
        testTenuringThreshold2();

    }

    /**
     * 新生代Minor GC
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB]; // 出现一次Minor GC
        /*
        Heap
         PSYoungGen      total 9216K, used 8192K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
          eden space 8192K, 100% used [0x00000000ff600000,0x00000000ffe00000,0x00000000ffe00000)
          from space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
          to   space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
         ParOldGen       total 10240K, used 4096K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
          object space 10240K, 40% used [0x00000000fec00000,0x00000000ff000010,0x00000000ff600000)
         Metaspace       used 3227K, capacity 4496K, committed 4864K, reserved 1056768K
          class space    used 350K, capacity 388K, committed 512K, reserved 1048576K
         */
    }

    /**
     * 大对象直接进入老年代
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=3145728
     */
    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * _1MB]; //直接分配在老年代中

        /*
        Heap
         par new generation   total 9216K, used 2555K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
          eden space 8192K,  31% used [0x00000000fec00000, 0x00000000fee7eff0, 0x00000000ff400000)
          from space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
          to   space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)
         concurrent mark-sweep generation total 10240K, used 4096K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
         Metaspace       used 3057K, capacity 4556K, committed 4864K, reserved 1056768K
          class space    used 324K, capacity 392K, committed 512K, reserved 1048576K
        Disconnected from the target VM, address: '127.0.0.1:1952', transport: 'socket'
         */
    }

    /**
     * 长期存活的对象进入老年代
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:Survivor-Ratio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
     */
    @SuppressWarnings("unused")
    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB / 4]; // 什么时候进入老年代决定于XX:MaxTenuring-Threshold设置
        allocation2 = new byte[4 * _1MB];
        /*
        Eden 8m 目前使用的4.256M 如果再执行下面代码需要minor gc Survivor 只有1M 所以allocation2（4M）直接进入老年代 allocation1（256k）
        进入Survivor age标记为1
         */
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        /*
        allocation2 太大直接进入老年代 allocation1 age达到阈值进入老年代
         */
        allocation3 = new byte[4 * _1MB];



        /*
[GC (Allocation Failure) [ParNew
Desired survivor size 524288 bytes, new threshold 1 (max 1)
- age   1:     948824 bytes,     948824 total
: 6597K->975K(9216K), 0.0024215 secs] 6597K->5073K(19456K), 0.0024870 secs] [Times: user=0.13 sys=0.00, real=0.00 secs]
[GC (Allocation Failure) [ParNew
Desired survivor size 524288 bytes, new threshold 1 (max 1)
: 5235K->0K(9216K), 0.0023315 secs] 9333K->4976K(19456K), 0.0023525 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
Heap
 par new generation   total 9216K, used 4178K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
  eden space 8192K,  51% used [0x00000000fec00000, 0x00000000ff014930, 0x00000000ff400000)
  from space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
  to   space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)
 concurrent mark-sweep generation total 10240K, used 4976K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
 Metaspace       used 3058K, capacity 4556K, committed 4864K, reserved 1056768K
  class space    used 324K, capacity 392K, committed 512K, reserved 1048576K
         */
    }


    /**
     * 动态对象年龄判定
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:MaxTenuringThreshold=15
     * -XX:+PrintTenuringDistribution
     */
    public static void testTenuringThreshold2() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB / 4]; // allocation1+allocation2大于survivo空间一半
        allocation2 = new byte[_1MB / 4];
        allocation3 = new byte[4 * _1MB];
        /*
        eden空间5M 执行下面代码需要先minor gc
        allocation3 直接进入老年代 allocation1和allocation2进入Survivor
         */
        allocation4 = new byte[4 * _1MB];

        allocation4 = null;
        allocation4 = new byte[4 * _1MB];
        /*
        [GC (Allocation Failure) [ParNew
Desired survivor size 524288 bytes, new threshold 1 (max 15)
- age   1:    1037424 bytes,    1037424 total
: 6853K->1024K(9216K), 0.0028898 secs] 6853K->5310K(19456K), 0.0029412 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[GC (Allocation Failure) [ParNew
Desired survivor size 524288 bytes, new threshold 15 (max 15)
: 5120K->0K(9216K), 0.0016030 secs] 9406K->5305K(19456K), 0.0016202 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[GC (CMS Initial Mark) [1 CMS-initial-mark: 5305K(10240K)] 9401K(19456K), 0.0001549 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[CMS-concurrent-mark-start]
[CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[CMS-concurrent-preclean-start]
[CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[CMS-concurrent-abortable-preclean-start]
Heap
 par new generation   total 9216K, used 4178K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
  eden space 8192K,  51% used [0x00000000fec00000, 0x00000000ff014930, 0x00000000ff400000)
  from space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
  to   space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)
 concurrent mark-sweep generation total 10240K, used 5305K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
 Metaspace       used 3058K, capacity 4556K, committed 4864K, reserved 1056768K
  class space    used 324K, capacity 392K, committed 512K, reserved 1048576K
Disconnected from the target VM, address: '127.0.0.1:8040', transport: 'socket'

Process finished with exit code 0

         */
    }
}
