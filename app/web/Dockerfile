# syntax=docker/dockerfile:1
# check=error=true

ARG NODE_VERSION=24.15.0
FROM node:${NODE_VERSION}-alpine as base

WORKDIR /app

FROM base AS deps
COPY package.json package-lock.json ./
RUN --mount=type=cache,target=/root/.npm \
    npm ci
    
FROM base AS dev

COPY --from=deps /app/node_modules ./node_modules
COPY . .

EXPOSE 5173

# Vite heeft --host nodig om bereikbaar te zijn buiten de container
CMD ["npm", "run", "dev", "--", "--host", "0.0.0.0"]

FROM base AS build
COPY --from=deps /app/node_modules ./node_modules
COPY . .
RUN npm run build

FROM nginxinc/nginx-unprivileged:alpine-slim AS final

# Kopieer de statische bestanden
COPY --from=build /app/dist /usr/share/nginx/html

# EXTREEM BELANGRIJK voor React Router:
# Zorg dat alle aanvragen naar index.html gaan
RUN echo 'server { \
    listen 8080; \
    location / { \
    root /usr/share/nginx/html; \
    index index.html; \
    try_files $uri $uri/ /index.html; \
    } \
    }' > /etc/nginx/conf.d/default.conf

EXPOSE 8080

CMD ["nginx", "-g", "daemon off;"]
