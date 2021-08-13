package osp.leobert.android.obbyma

/**
 * BasicMapper desc: 基础数据类型的转换，一般情况下 </p>
 *
 * Created by leobert on 2021/8/3.
 */
abstract class BasicMapper<T> {

    abstract fun object2Bytes(obj: T?, target: IBytesStore, length: Int)
    abstract fun bytes2Object(from: IBytesStore, length: Int): T?

}
