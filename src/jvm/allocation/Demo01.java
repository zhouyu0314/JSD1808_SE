package jvm.allocation;

/**
 * -XX:+UseConcMarkSweepGC 使用cms
 */
public class Demo01 {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        //testAllocation();
        //testPretenureSizeThreshold();
        testTenuringThreshold();


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
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:Survivor-
     * Ratio=8 -XX:MaxTenuringThreshold=1
     * -XX:+PrintTenuringDistribution
     */
    @SuppressWarnings("unused")
    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB / 4]; // 什么时候进入老年代决定于XX:MaxTenuring-Threshold设置
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];


        /*
        [GC (Allocation Failure) [ParNew
        Desired survivor size 524288 bytes, new threshold 1 (max 1)
        - age   1:     878632 bytes,     878632 total
        : 6341K->878K(9216K), 0.0048594 secs] 6341K->4977K(19456K), 0.0054887 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        [GC (Allocation Failure) [ParNew
        Desired survivor size 524288 bytes, new threshold 1 (max 1)
        - age   1:        800 bytes,        800 total
        : 5059K->482K(9216K), 0.0019171 secs] 9157K->5445K(19456K), 0.0019404 secs] [Times: user=0.05 sys=0.00, real=0.00 secs]
        Heap
         par new generation   total 9216K, used 4716K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
          eden space 8192K,  51% used [0x00000000fec00000, 0x00000000ff022760, 0x00000000ff400000)
          from space 1024K,  47% used [0x00000000ff400000, 0x00000000ff478ba0, 0x00000000ff500000)
          to   space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)
         concurrent mark-sweep generation total 10240K, used 4962K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
         Metaspace       used 3208K, capacity 4496K, committed 4864K, reserved 1056768K
          class space    used 347K, capacity 388K, committed 512K, reserved 1048576K
         */
    }
}
