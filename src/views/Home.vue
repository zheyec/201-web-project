<template>
    <div class="sidebar">
        <!-- <h2>Dress the vibe!</h2> -->
        <pickColorSection
            @query-selected-colors="handleSearch"
            :popularColorDatas="popularColors"
        />
    </div>

    <div class="mainArea">
        <h1>Colorly</h1>
        <div class="itemCard" :key="item.id" v-for="item in items">
            <ShoppingItem
                @item-added-to-cart="addToCart"
                :shoppingItem="item"
            />
        </div>
    </div>

    <div class="clearfloat"></div>
</template>

<script>
import ShoppingItem from "../components/ShoppingItem.vue";
import PickColorSection from "../components/pickColorSection.vue";

export default {
    name: "Home",
    props: {
        userInfo: Object,
    },
    components: {
        ShoppingItem,
        PickColorSection,
    },
    methods: {
        onSearch(searchKeyword) {
            console.log(searchKeyword);
            // TODO: send searchKeyword to backend and update this.items
        },
        async handleSearch(colors) {
            let colorsData = {
                color1: colors[0],
                color2: colors[1],
                color3: colors[2],
            };
            let response = await fetch("http://localhost:8081/items/search", {
                method: "POST",
                body: new URLSearchParams(colorsData),
            });
            if (response.status == 200) {
                this.items = await response.json();
            } else {
                alert((await response.json()).error);
            }
        },
        async addToCart(data) {
            // when Add to Cart Button is clicked
            // send itemID to backend for processing/store to DB
            const response = await fetch(
                `http://localhost:8081/cart/items/${data.id}`,
                {
                    method: "PUT",
                    credentials: "include",
                }
            );

            if (response.status == 200) {
                data.elem.classList.remove("itemNotAddedButton");
                data.elem.classList.add("itemAddedButton");
            } else {
                alert((await response.json()).error);
            }
        },
    },
    data() {
        return {
            items: [],
            popularColors: [],
        };
    },
    async created() {
        this.popularColors = [
            {
                id: 1,
                colorHexCode: "#000",
            },
            {
                id: 2,
                colorHexCode: "#000",
            },
            {
                id: 3,
                colorHexCode: "#000",
            },
        ];
        const response = await fetch("http://localhost:8081/items/all", {
            method: "GET",
        });
        if (response.status == 200) {
            this.items = [...(await response.json())];
        } else {
            alert((await response.json()).error);
        }
    },
};
</script>

<style scoped>
.itemCard {
    margin-left: 30px;
    margin-bottom: 200px;
}
</style>
