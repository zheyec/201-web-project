<template>
    <div class="SignIn">
        <img al t="Colorly logo" src="../assets/colorlylogo.png" height="200" />
        <form>
            <input
                type="text"
                id="username"
                name="username"
                placeholder="USERNAME"
                v-model="input.username"
                size="50"
            /><br /><br />
            <input
                type="password"
                id="password"
                name="password"
                placeholder="PASSWORD"
                v-model="input.password"
                size="50"
            /><br /><br />
        </form>
        <button type="submit" v-on:click="loginPressed">LOGIN</button>

        <footer>
            <p>Don't have an account? <a href="/create"> Sign Up!</a></p>
        </footer>
    </div>
</template>

<script>
export default {
    name: "SignIn",
    data() {
        return {
            input: {},
        };
    },
    methods: {
        async loginPressed() {
            var url = "http://localhost:8081/user/login";
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            const requestBody = {
                username,
                password,
            };
            const response = await fetch(url, {
                method: "POST",
                credentials: "include",
                body: new URLSearchParams(requestBody),
            });

            if (response.status == 200) {
                this.$cookies.set(
                    "userInfo",
                    JSON.stringify(await response.json())
                );
                this.$cookies.set("loggedIn", "true");
                window.location = "/";
            } else {
                alert((await response.json()).error);
            }
        },
    },
};
</script>

<style scoped>
h3 {
    margin: 40px 0 0;
}
ul {
    list-style-type: none;
    padding: 0;
}
li {
    display: inline-block;
    margin: 0 10px;
}
a {
    color: #42b983;
}
</style>
