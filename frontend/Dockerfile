# Development Dockerfile.
#
# Runs the Angular dev server (ng serve) so you get live-reload when editing
# code on your host machine. This is NOT how you'd package a production
# build (see Module 12, which introduces a multi-stage build served by nginx
# instead).
FROM node:22

WORKDIR /app

# Copy just the package files first so Docker can cache "npm install"
# separately from your actual source code.
COPY package.json package-lock.json ./
RUN npm install

# Source code is bind-mounted over this in docker-compose.yml for
# live-reload during development; this COPY just means the image also works
# standalone.
COPY . .

EXPOSE 4200

# --host 0.0.0.0 is required so the dev server is reachable from outside the
# container (by default it only listens on localhost inside the container).
CMD ["npx", "ng", "serve", "--host", "0.0.0.0"]
