import { defineConfig } from "vite";
import symfonyPlugin from "vite-plugin-symfony";
import vuePlugin from "@vitejs/plugin-vue";
import tailwindcss from '@tailwindcss/vite'


export default defineConfig({

    server: {
        host: '127.0.0.1',

    },
    plugins: [
        vuePlugin(),
        symfonyPlugin({
            stimulus: true
        }),
        tailwindcss(),
    ],
    build: {
        rollupOptions: {
            input: {
                app: "./assets/app.js"
            },
        }
    },
});
