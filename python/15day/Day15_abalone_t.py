#!/usr/bin/env python
# coding: utf-8

# In[10]:


import requests
import numpy as np
import matplotlib.pyplot as plt
import sqlite3


# In[28]:


def fetch_uci_data(url):
    d = requests.get(url)
    t = []
    for line in d.text.split('\n'):
        if len(line)!=0:
            t.append(line.split(','))
    return np.array(t)

def get_corr(d):
    male_filter = d[:,0]=='M'
    male_samples = d[male_filter]
    male_length = male_samples[:,1].astype(np.float64)
    male_diameter = male_samples[:,2].astype(np.float64)
    return np.corrcoef(male_length,male_diameter)


# In[29]:


url = 'https://archive.ics.uci.edu/ml/machine-learning-databases/abalone/abalone.data'

if __name__ == '__main__':
    np_data = fetch_uci_data(url)
    corr_value = get_corr(np_data)
    print(corr_value)


# In[30]:


con = sqlite3.connect("test.db")
cur = con.cursor()
cur.execute("CREATE TABLE abalone(length real, diameter real)")
cur.execute("INSERT INTO abalone(length, diameter) values(10.0, 20.0)")
con.commit()
con.close


# In[34]:


con = sqlite3.connect("test.db")
cur = con.cursor()
res = cur.execute("SELECT * from abalone")
print(res.fetchall())

