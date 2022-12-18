package ink.gxy.android.addressbook

import ink.gxy.android.addressbook.ContactRepository.contacts
import ink.gxy.android.addressbook.ContactRepository.faker
import net.datafaker.Faker
import java.util.*

/**
 * 联系人 Repository 类（Mock）
 *
 * @property contacts 数据列表
 * @property faker mock 数据生成器
 */
object ContactRepository {
    private val contacts = mutableListOf<Contact>()
    private val faker = Faker(Locale("zh-cn"))

    init {
        // 清空数据
        contacts.clear()
        // 添加 20 条随机数据
        repeat(20) {
            contacts.add(generate())
        }
    }

    // 生成随机 Contact 对象
    private fun generate() = Contact(faker.number().randomNumber(), faker.name().fullName())

    // 获取联系人列表
    fun fetch(): List<Contact> = contacts

    // 添加一位联系人
    fun add() = contacts.add(generate())
}