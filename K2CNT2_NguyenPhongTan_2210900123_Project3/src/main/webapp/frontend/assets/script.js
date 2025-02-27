let cart = JSON.parse(localStorage.getItem("cart")) || [];

function addToCart(button) {
    let vehicleCard = button.parentElement;
    let id = vehicleCard.getAttribute("data-id");
    let name = vehicleCard.getAttribute("data-name");
    let price = parseFloat(vehicleCard.getAttribute("data-price"));

    let item = { id, name, price };

    cart.push(item);
    localStorage.setItem("cart", JSON.stringify(cart));
    alert("Đã thêm xe vào giỏ hàng!");
}

function loadCart() {
    let cartItems = document.getElementById("cart-items");
    let totalPrice = document.getElementById("total-price");
    cartItems.innerHTML = "";
    let total = 0;

    cart.forEach((item, index) => {
        cartItems.innerHTML += `
            <div>
                ${item.name} - ${item.price} USD
                <button onclick="removeItem(${index})">Xóa</button>
            </div>
        `;
        total += item.price;
    });

    totalPrice.innerText = total;
}

function removeItem(index) {
    cart.splice(index, 1);
    localStorage.setItem("cart", JSON.stringify(cart));
    loadCart();
}

function clearCart() {
    cart = [];
    localStorage.setItem("cart", JSON.stringify(cart));
    loadCart();
}

if (window.location.pathname.includes("cart.html")) {
    loadCart();
}
