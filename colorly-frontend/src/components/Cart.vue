<template>
    <div class="wholepage">
        <div class="cartImageContainer">
            <a :href="cartDetailURL" target="_blank">
                <img id="cartImage" :src="outfit.items[0].picture" />
            </a>
        </div>

        <div id="cartDetail">
            <a :href="cartDetailURL" target="_blank">
                <p>
                    <strong> {{ outfit.owner.username }}'s<br />Cart</strong>
                </p>
            </a>
            <div v-show="!ranked" class="like">
                <button
                    class="LikeButton"
                    v-on:click="LikeClick"
                >
                    <strong>Like</strong>
                </button>
            </div>
            <div v-show="ranked" class="like">
                <button
                    class="DisLikeButton"
                    v-on:click="UnlikeClick"
                >
                    <strong>Unlike</strong>
                </button>
            </div>
        </div>
    </div>

    <div class="clearfloat"></div>
</template>

<script>
export default {
    name: "Cart",
    props: {
        outfit: Object,
    },
    data() {
        return {
            ranked: false,
            cartDetailURL: "/userscart?id=" + this.outfit.id,
        };
    },
    async created() {
        let response = await fetch(`http://localhost:8081/outfits/${this.outfit.id}/liked`, {
            method: "GET",
            credentials: "include"
        });
        let responseObj = await response.json();
        if (response.status == 200) {
            this.ranked = responseObj.liked;
        } else if (response.status != 401) {
            alert(responseObj.error);
        }
    },
    methods: {
        async LikeClick() {
            const response = await fetch(
                `http://localhost:8081/outfits/${this.outfit.id}/like`,
                {
                    method: "GET",
                    credentials: "include",
                }
            );
            if (response.status == 200) {
                this.ranked = true;
            } else {
                alert((await response.json()).error);
            }
        },
        async UnlikeClick() {
            const response = await fetch(
                `http://localhost:8081/outfits/${this.outfit.id}/unlike`,
                {
                    method: "GET",
                    credentials: "include",
                }
            );
            if (response.status == 200) {
                this.ranked = false;
            } else {
                alert((await response.json()).error);
            }
        },
    },
};
</script>

<style scoped>
main {
    clear: both;
    font-size: 0.75rem;
    margin: 0 auto;
    overflow: hidden;
    padding: 1rem 0;
    width: 960px;
    margin-left: 220px;
    margin-top: 0px;
}

@media screen and (max-width: 960px) {
    main {
        width: 100%;
    }
    .cartDetail {
        padding: 0 1rem;
    }
}

.DisLikeButton {
    background-color: orange;
    cursor: pointer;
    color: white;
    text-align: center;
}

.LikeButton {
    background-color: green;
    cursor: pointer;
    color: white;
    text-align: center;
}

.itemlikedText {
    size: 2px;
    color: orange;
    visibility: visible;
}

.itemdislikedText {
    size: 2px;
    margin: auto;
    color: green;
    visibility: visible;
}

.itemNotRankedText {
    visibility: hidden;
}

#cartDetail {
    size: 5px;
    padding-bottom: 100px;
}

#cartImage {
    max-width: 100%;
    max-height: 100%;
    align-content: center;
    /* OR */
    /* width: 100%; */
}

.cartImageContainer {
    height: 180px;
    width: 150px;
    overflow: hidden;
    /* position: relative; Not sure if needed */
}

.wholepage {
    height: 500px;
    width: 200px;
    /* background-color: cyan; */

    float: left;
    padding-left: 40px;
    padding-right: 40px;
    padding-top: 40px;
    padding-bottom: 60px;
}
</style>
