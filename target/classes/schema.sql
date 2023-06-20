CREATE TABLE client(
    client_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(75) NOT NULL,
    surname VARCHAR(75) NOT NULL,
    dni INTEGER UNIQUE NOT NULL
);
CREATE TABLE product(
    product_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(150) NOT NULL,
    description VARCHAR(150) NOT NULL,
    stock INTEGER NOT NULL,
    product_price FLOAT NOT NULL,
    internal_code VARCHAR(20) NOT NULL

);
CREATE TABLE invoice(
    invoice_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    client_id INTEGER NOT NULL,
    created_at DATETIME NOT NULL,
    total FLOAT NOT NULL
);
CREATE TABLE invoice_detail(
    id_invoice  	id_product  	invoice_detail_id  	price  	quantity  
    invoice_detail_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    id_invoice INTEGER NOT NULL,
    id_product INTEGER NOT NULL,
    price FLOAT NOT NULL,
    quantity INTEGER NOT NULL
)

