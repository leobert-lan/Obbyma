package osp.leobert.android.obbyma

/**
 * Mapper </p>
 * <p><b>Description:</b> 基本类型映射 </p>
 * Created by leobert on 2021/8/3.
 */
abstract class Mapper<T> {

    abstract fun object2Bytes(obj: T, target: IBytesStore, length: Int)
    abstract fun bytes2Object(obj: T, from: IBytesStore, length: Int)
}