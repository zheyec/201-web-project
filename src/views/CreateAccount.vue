<template>
    <div class="create">
        <h1>Create Your Colorly Acccount</h1>
        <form>
            <input
                type="text"
                id="username"
                name="username"
                placeholder="USERNAME"
                size="50"
            /><br /><br />
            <input
                type="text"
                id="email"
                name="email"
                placeholder="EMAIL"
                size="50"
            /><br /><br />
            <input
                type="password"
                id="password"
                name="password"
                placeholder="PASSWORD"
                size="50"
            /><br /><br />
        </form>
        <button type="submit" v-on:click="createPressed">CREATE!</button>
    </div>
</template>

<script>
export default {
    name: "CreateAccount",

    methods: {
        async createPressed() {
            var url = "http://localhost:8081/user/register";
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            var email = document.getElementById("email").value;
            const requestBody = {
                username,
                password,
                Email: email,
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
