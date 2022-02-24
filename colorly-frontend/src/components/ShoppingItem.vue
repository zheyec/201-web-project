<template>
    <div class="whole">
        <div class="itemImageContainer">
            <img id="itemImage" :src="shoppingItem.picture" />
        </div>

        <div id="ItemDetail">
            <p>{{ shoppingItem.name }}</p>
            <p><b>Description: </b>{{ shoppingItem.description }}</p>
            <p><b>Price: </b> ${{ shoppingItem.price }}</p>
            <p>
                <b>Source: </b>
                <a target="_blank" :href="shoppingItem.source">{{
                    shoppingItem.brand
                }}</a>
            </p>
            <button class="itemNotAddedButton" v-on:click="addToCartBtnClick">
                +
            </button>
        </div>
    </div>
</template>

<script>
// import { defineComponent } from '@vue/composition-api'

export default {
    name: "ShoppingItem",
    methods: {
        addToCartBtnClick(event) {
            this.$emit("item-added-to-cart", {
                elem: event.target,
                id: this.shoppingItem.id,
            });
        },
    },
    props: {
        shoppingItem: Object,
    },
};
</script>

<style scoped>
.itemAddedButton {
    visibility: hidden;
    size: 0px;
}

.itemNotAddedButton {
    background-color: white;

    cursor: pointer;
}

.itemAddedText {
    size: 2px;
    color: green;
    visibility: visible;
}

.itemNotAddedText {
    visibility: hidden;
}

#ItemDetial {
    size: 5px;
}
#itemImage {
    max-width: 100%;
    max-height: 100%;
    align-content: center;
    /* OR */
    /* width: 100%; */
}

.itemImageContainer {
    height: 200px;
    width: 150px;
    overflow: hidden;
    /* position: relative; Not sure if needed */
}

.whole {
    height: 400px;
    width: 155px;
    /* background-color: cyan; */

    padding-left: 10px;
    padding-right: 10px;
    padding-top: 15px;
    padding-bottom: 15px;
}
</style>
