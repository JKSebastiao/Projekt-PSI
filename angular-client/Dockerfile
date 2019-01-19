# Installs the current application on a Node Image.
FROM node:10.5

# The qq is for silent output in the console
# You are welcome to modify this part as it
RUN apt-get update -qq && apt-get install -y build-essential libpq-dev vim

# Sets the path where the app is going to be installed
ENV NODE_ROOT /usr/src/app/

# Creates the directory and all the parents (if they don’t exist)
RUN mkdir -p $NODE_ROOT

# Sets the /usr/app as the active directory
WORKDIR $NODE_ROOT


# install and cache app dependencies
COPY package.json /usr/src/app/package.json
RUN npm install
RUN npm install -g @angular/cli

# add app
COPY . /usr/src/app
RUN ls /usr/src/app
RUN cd /usr/src/app

# Uncomment this if you are using Windows (Windows Only)
# RUN npm rebuild node-sass --force

# The default port from ng serve (4200)
# and 49153 for Webpack Hot Module Reload
EXPOSE 4200 49153

# start app
CMD ng serve --host 0.0.0.0
