import request from '@/utils/request'

// 查询会员信息列表
export function listViprole(query) {
  return request({
    url: '/system/viprole/list',
    method: 'get',
    params: query
  })
}

// 查询会员信息详细
export function getViprole(id) {
  return request({
    url: '/system/viprole/' + id,
    method: 'get'
  })
}

// 新增会员信息
export function addViprole(data) {
  return request({
    url: '/system/viprole',
    method: 'post',
    data: data
  })
}

// 修改会员信息
export function updateViprole(data) {
  return request({
    url: '/system/viprole',
    method: 'put',
    data: data
  })
}

// 删除会员信息
export function delViprole(id) {
  return request({
    url: '/system/viprole/' + id,
    method: 'delete'
  })
}
