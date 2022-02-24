<template>
    <div class="basket-product">
        <div class="item">
            <div class="product-image">
                <img
                    :src="product.picture"
                    :alt="product.name"
                    class="product-frame"
                />
            </div>
            <div class="product-details">
                <h1><b>Name: </b>{{ product.name }}</h1>
                <h1><b>Description: </b>{{ product.description }}</h1>
                <h1><b>Price: </b>${{ product.price }}</h1>
                <h1>
                    <b>Source: </b
                    ><a target="_blank" :href="product.source">{{
                        product.brand
                    }}</a>
                </h1>
            </div>
        </div>
        <div class="price">{{ product.price }}</div>
    </div>
</template>

<script>
export default {
    name: "popularCartItem",
    props: {
        product: Object,
    },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css?family=Open+Sans:400,700,600");

html,
html a {
    -webkit-font-smoothing: antialiased;
    text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.004);
}

body {
    background-color: #fff;
    color: #666;
    font-family: "Open Sans", sans-serif;
    font-size: 62.5%;
    margin: 0 auto;
}

a {
    border: 0 none;
    outline: 0;
    text-decoration: none;
}

strong {
    font-weight: bold;
}

p {
    margin: 0.75rem 0 0;
}

h1 {
    font-size: 0.75rem;
    font-weight: normal;
    margin: 0;
    padding: 0;
    text-align: left;
}

input,
button {
    border: 0 none;
    outline: 0 none;
}

button {
    background-color: #666;
    color: #fff;
}

button:hover,
button:focus {
    background-color: #555;
}

img,
.basket-module,
.basket-labels,
.basket-product {
    width: 100%;
}

input,
button,
.basket,
.basket-module,
.basket-labels,
.item,
.price,
.quantity,
.subtotal,
.basket-product,
.product-image,
.product-details {
    float: left;
}

.price:before,
.subtotal:before,
.subtotal-value:before,
.total-value:before,
.promo-value:before {
    content: "$";
}

.hide {
    display: none;
}

.basket,
aside {
    padding: 0 1rem;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
}

.basket {
    width: 70%;
}

.basket-module {
    color: #111;
}

label {
    display: block;
    margin-bottom: 0.3125rem;
}

.basket-labels {
    border-top: 1px solid #ccc;
    border-bottom: 1px solid #ccc;
    margin-top: 1.625rem;
}

.item {
    width: 55%;
}

.price,
.quantity,
.subtotal {
    width: 30%;
}

.remove {
    bottom: 1.125rem;
    float: right;
    position: absolute;
    right: 0;
    text-align: right;
    width: 45%;
}

.remove button {
    background-color: transparent;
    color: #777;
    float: none;
    text-decoration: underline;
    text-transform: uppercase;
    cursor: pointer;
}

.item-heading {
    padding-left: 4.375rem;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
}

.basket-product {
    border-bottom: 1px solid #ccc;
    padding: 1rem 0;
    position: relative;
}

.product-image {
    width: 35%;
}

.product-details {
    width: 65%;
}

.product-frame {
    border: 1px solid #aaa;
}

.product-details {
    padding: 0 1.5rem;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
}

.quantity-field {
    background-color: #ccc;
    border: 1px solid #aaa;
    border-radius: 4px;
    font-size: 0.625rem;
    padding: 2px;
    width: 3.75rem;
}

aside {
    float: right;
    position: relative;
    width: 30%;
}

.subtotal-title,
.subtotal-value,
.total-title,
.total-value,
.promo-title,
.promo-value {
    color: #111;
    float: left;
    width: 50%;
}

.subtotal-value,
.total-value {
    text-align: right;
}

.total-title {
    font-weight: bold;
    text-transform: uppercase;
}

.summary-checkout {
    display: block;
}

.checkout-cta {
    display: block;
    float: none;
    font-size: 0.75rem;
    text-align: center;
    text-transform: uppercase;
    padding: 0.625rem 0;
    width: 100%;
}

.summary-delivery-selection {
    background-color: #ccc;
    border: 1px solid #aaa;
    border-radius: 4px;
    display: block;
    font-size: 0.625rem;
    height: 34px;
    width: 100%;
}

@media screen and (max-width: 640px) {
    aside,
    .basket,
    .summary,
    .item,
    .remove {
        width: 100%;
    }
    .basket-labels {
        display: none;
    }
    .basket-module {
        margin-bottom: 1rem;
    }
    .item {
        margin-bottom: 1rem;
    }
    .product-image {
        width: 40%;
    }
    .product-details {
        width: 60%;
    }
    .price,
    .subtotal {
        width: 33%;
    }

    .remove {
        bottom: 0;
        text-align: left;
        margin-top: 0.75rem;
        position: relative;
        cursor: pointer;
    }
    .remove button {
        padding: 0;
        cursor: pointer;
    }
}

@media screen and (min-width: 641px) and (max-width: 960px) {
    aside {
        padding: 0 1rem 0 0;
    }
}

@media screen and (max-width: 960px) {
    main {
        width: 100%;
    }
    .product-details {
        padding: 0 1rem;
    }
}
</style>
