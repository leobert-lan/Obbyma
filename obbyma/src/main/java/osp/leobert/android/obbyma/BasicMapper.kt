package osp.leobert.android.obbyma

/**
 * BasicMapper desc: TODO </p>
 *
 * Created by leobert on 2021/8/3.
 */
abstract class BasicMapper<T> {

    abstract fun object2Bytes(obj: T?, target: IBytesStore, length: Int)
    abstract fun bytes2Object(from: IBytesStore, length: Int): T?

}
