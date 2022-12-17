package ink.gxy.android.addressbook

import net.datafaker.Faker
import java.util.*


object ContactRepository {

    private val contacts = mutableListOf<Contact>()
    private val faker = Faker(Locale("zh-cn"))

    private fun generate() = Contact(faker.number().randomNumber(), faker.name().fullName())

    fun fetch(): List<Contact> = contacts

    fun add() = contacts.add(generate())

    init {
        contacts.clear()
        repeat(20) {
            contacts.add(generate())
        }
    }
}