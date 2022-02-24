<template>
    <h1>Community</h1>
    <div class="mainArea">
        <div :key="outfitcart.id" v-for="outfitcart in carts">
            <Cart :outfit="outfitcart" />
        </div>
    </div>
</template>

<script>
import Cart from "../components/Cart.vue";

export default {
    name: "Community",
    components: {
        Cart,
    },
    data() {
        return {
            carts: [],
        };
    },
    props: {
        cartsInfo: Array,
    },

    async created() {
        var url = "http://localhost:8081/outfits/all";
        const response = await fetch(url, {
            method: "GET",
        });

        if (response.status == 200) {
            this.carts = [...(await response.json())];
        } else {
            alert((await response.json()).error);
        }
    },
};
</script>

<style scoped>
.basket {
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

.mainArea {
    width: 100%;
    /* top: 0px; */
    /* z-index: 1; */
    float: left;
    align-content: center;
    margin-left: 20px;
    margin-top: 20px;
    margin-right: 20px;
    margin-bottom: 20px;
}

@media screen and (max-width: 640px) {
    aside,
    .basket,
    .item {
        width: 100%;
    }
    .basket-labels {
        display: none;
    }
    .basket-module {
        margin-bottom: 1rem;
    }
    .product-image {
        width: 40%;
    }
    .product-details {
        width: 60%;
    }

    .outfitCard {
        float: left;
    }
}
</style>
