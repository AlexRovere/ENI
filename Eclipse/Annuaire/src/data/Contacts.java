package data;
import java.io.Serializable;
import java.util.List;

import bo.Contact;

public record Contacts(List<Contact> contacts) implements Serializable {}
