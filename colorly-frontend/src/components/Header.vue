<template>
    <nav>
        <div id="headerWrapper">
            <a class="pageLink" href="/"
                ><div class="linkTextWrapper">Home</div></a
            >
            <a class="pageLink" href="/community"
                ><div class="linkTextWrapper">Community</div></a
            >
            <a class="pageLink" href="/ranking"
                ><div class="linkTextWrapper">Ranking</div></a
            >
            <a class="pageLink" href="/mycart"
                ><div class="linkTextWrapper">My Cart</div></a
            >
            <a v-show="!loggedIn" class="pageLink" href="/signin"
                ><div class="linkTextWrapper">Sign In / Sign Up</div></a
            >
            <a
                v-show="loggedIn"
                class="pageLink"
                @click="onLogout"
                href="#"
                ><div class="linkTextWrapper">Logout</div></a
            >
        </div>
        <div class="clearfloat"></div>
    </nav>
</template>

<script>
export default {
    name: "Header",
    data() {
        return {
            loggedIn: false,
        };
    },
    async created() {
        this.loggedIn = this.$cookies.get("loggedIn") === "true";
    },
    methods: {
        async onLogout() {
            let response = await fetch("http://localhost:8081/user/logout", {
                credentials: "include",
            });
            if (response.status == 200) {
                this.$cookies.set("userInfo", JSON.stringify({}));
                this.$cookies.set("loggedIn", "false");
                window.location = "/";
            } else {
                alert((await response.json()).error);
            }
        },
    },
};
</script>

<style scoped>
#signInButton :hover {
    background-color: #ffc72c;
    color: tomato;
}

#headerWrapper {
    margin-left: 100px;
    width: 1000px; /*increase this if more options added to navbar = 200 * #items */
}

.clearfloat {
    float: none;
}
nav {
    margin-left: auto;
    margin-right: auto;
    height: 70px;
    background-color: black;
    margin-top: 0px;
}

.pageLink {
    width: 200px;
    /* width: 25%; */
    padding-top: 10px;
    color: white;
    /* background-color: pink; */
    text-align: center;
    float: left;
}

.linkTextWrapper {
    height: 45px;
    padding-top: 5px;
    /* margin-top: 5px; */
    margin-bottom: 5px;
    font-size: 19px;
    font-weight: 800;
}

.pageLink :hover {
    background-color: white;
    color: tomato;
}
</style>
