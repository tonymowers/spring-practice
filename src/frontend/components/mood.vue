<template>
    <div class="mood">{{ name }}</div>
</template>

<script>
    export default {
        props: {
            name: String
        }
    }
</script>

<style lang="scss">
    .mood {
        width: 160px;
        height: 20px;
        padding: 15px;
        margin: 0px 15px 15px 15px;
        border: solid #aaa 1px;
        border-radius: 5px;
        text-align: center;

        &:hover {
            background-color: lightgray;
            width: 170px;
            margin: 0px 10px 10px 10px;
            padding-top: 20px;
        }
    }
</style>