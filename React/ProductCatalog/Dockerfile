FROM node:22-alpine
WORKDIR /ProductCatalog
COPY package.json ./
RUN npm install
RUN npm install @rollup/rollup-linux-x64-musl@4.44.2
COPY . .

CMD ["npm", "run", "dev"]